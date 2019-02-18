package com.deepexi.ai.mes.service.impl;

import com.deepexi.ai.mes.dao.*;
import com.deepexi.ai.mes.dto.TestTaskDto;
import com.deepexi.ai.mes.dto.TestTaskPostDto;
import com.deepexi.ai.mes.dto.TestTaskRequestDto;
import com.deepexi.ai.mes.enums.TestTaskStatusEnums;
import com.deepexi.ai.mes.model.*;
import com.deepexi.ai.mes.service.ITestTaskService;
import com.deepexi.ai.mes.utils.WeightTestResultThread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author lyon
 * @date   2018/12/5 11:17
 * @detail 测试任务Service接口实现类
 */
@Service
public class TestTaskService implements ITestTaskService {

    @Autowired
    TestResultService testResultService;

    @Autowired
    ITestResultDao testResultDao;

    @Autowired
    ITestDatasetDao testDatasetDao;

    @Autowired
    ITestTaskDao testTaskDao;

    @Autowired
    ITestTaskDetailDao testTaskDetailDao;

    @Autowired
    IModelDao modelDao;

    @Autowired
    IWeightDao weightDao;

    @Autowired
    MongoTemplate mongoTemplate;

    //自动筛选20个权重
    private final Integer AUTO_WEIGHT = 0;
    //全部权重
    private final Integer ALL_WEIGHT = 1;

    private final String TESTTASK_RESULT_URI = "http://192.168.3.124:8050/";
    //private final String TESTTASK_RESULT_URI = "http://localhost:8080/";

    @Override
    public TestTaskPostDto createTestingTask(TestTaskPostDto testTaskPostDto) throws Exception {
        TestTask testTask = testTaskPostDto.getTestTask();
        Model model = modelDao.findById(testTask.getModelId()).orElseThrow(() -> new EntityNotFoundException("未找到该测试任务下的模型"));
        testTaskPostDto.setModelName(model.getModelName());
        Integer weightChoice = testTask.getWeightChoice();
        List<Weight> weights = new ArrayList<>();
        //如果weightChoice=AUTO_WEIGHT则自动选择20个最优权重，否则选择全部权重
        if(weightChoice.equals(AUTO_WEIGHT)){
//            /*根据测试结果中posiibility字段降序筛选前20条记录的modelId字段
//             *
//             * 【mongoDB语法】:db.getCollection('testResult').find({}).sort({'possibility':-1}).limit(20)
//             */
//            Query query = new Query(new Criteria());
//            Sort sort = new Sort(Sort.Direction.DESC,"possibility");
//            List<TestResult> testResults = mongoTemplate.find(query.with(sort),TestResult.class);
//            for(int i=0; i<testResults.size(); i++){
//                Weight weight = new Weight();
//                weight.setId(testResults.get(i).getWeightId());
//                weights.add(weight);
//            }
            //从所有权重结果中取前20条
            List<Weight> temp = weightDao.findWeightsByModelId(testTask.getModelId());
            int length = (temp.size()>=20) ? 20 : temp.size();
            for(int j=0; j<length; j++){
                weights.add(temp.get(j));
            }
        }else{
            weights = weightDao.findWeightsByModelId(testTask.getModelId());
        }
        testTask.setWeightList(weights);
        testTaskDao.save(testTask);
        //根据筛选出的weight列表，逐个创建子权重测试。创建等待队列
        BlockingQueue<Runnable> bqueue = new ArrayBlockingQueue<Runnable>(2000);
        //创建线程池，池中核心线程数为1，允许的最大线程数1
        ThreadPoolExecutor pool = new ThreadPoolExecutor(1,1,100, TimeUnit.MILLISECONDS,bqueue);
        List<TestTaskDetail> taskDetails = new ArrayList<>(weights.size());
        for(int i=0; i<weights.size(); i++){
            TestTaskDetail detail = new TestTaskDetail();
            detail.setAccuracy("99.8%");
            detail.setAuc(0.68);
            detail.setTestTaskId(testTask.getId());
            detail.setWeightId(weights.get(i).getId());
            detail.setWeightName(weights.get(i).getWeightName());
            taskDetails.add(detail);
            String url = TESTTASK_RESULT_URI + weights.get(i).getWeightName();
            Runnable t = new WeightTestResultThread(url);
            pool.execute(t);
        }
        pool.shutdown();
        testTaskDetailDao.saveAll(taskDetails);
        return testTaskPostDto;
    }

    @Override
    public TestTaskRequestDto getModelTestTaskList(String modelId,String testDatasetId) {
        TestTaskRequestDto dto = new TestTaskRequestDto();
        TestTask testTask = testTaskDao.findByModelIdAndTestDatasetId(modelId,testDatasetId);
        List<TestTaskDetail> details = testTaskDetailDao.findTestTaskDetailsByTestTaskId(testTask.getId());
        dto.setTestTask(testTask);
        dto.setTestTaskDetails(details);
        return dto;
    }

    @Override
    public TestTaskRequestDto getTestTaskDetail(String testTaskId) throws Exception{
        TestTaskRequestDto dto = new TestTaskRequestDto();
        TestTask testTask = testTaskDao.findById(testTaskId).orElseThrow(() -> new EntityNotFoundException("无此测试任务！"));
        dto.setTestTaskCreator("central");
        dto.setTestTask(testTask);
        //获取权重测试详情
        List<TestTaskDetail> details = testTaskDetailDao.findTestTaskDetailsByTestTaskId(testTaskId);
        dto.setTestTaskDetails(details);
        //获取测试集名称
        TestDataSet testDataSet = testDatasetDao.findById(testTask.getTestDatasetId()).orElseThrow(() -> new EntityNotFoundException("未找到该测试任务下的测试集"));
        dto.setTestDatasetName(testDataSet.getTestDatasetName());
        //获取模型名称
        Model model = modelDao.findById(testTask.getModelId()).orElseThrow(() -> new EntityNotFoundException("未找到该测试任务下的模型"));
        dto.setModelName(model.getModelName());
        return dto;
    }

    @Override
    public List<TestTaskDto> findAllTestTask() {
        List<TestTask> testTasks = testTaskDao.findAll();
        List<TestTaskDto> testTaskDtos = new ArrayList<>(testTasks.size());
        for(int i=0; i<testTasks.size(); i++){
            TestTask testTask = testTasks.get(i);
            TestTaskDto testTaskDto = new TestTaskDto();
            testTaskDto.setTestTask(testTask);
            testTaskDto.setCreatAt(testTask.getCreateDate());
            try {
                //获取测试集名称
                TestDataSet testDataSet = testDatasetDao.findById(testTask.getTestDatasetId()).orElseThrow(() -> new EntityNotFoundException("未找到该测试任务下的测试集"));
                testTaskDto.setTestDatasetName(testDataSet.getTestDatasetName());
                //获取模型名称
                Model model = modelDao.findById(testTask.getModelId()).orElseThrow(() -> new EntityNotFoundException("未找到该测试任务下的模型"));
                testTaskDto.setModelName(model.getModelName());
            }catch (EntityNotFoundException e){
                System.out.println("TestTaskService.findAllTestTask()方法：获取测试任务下的测试集名称Or获取模型名称失败");
            }
            testTaskDto.setCreator("central");
            testTaskDtos.add(testTaskDto);
        }
        return testTaskDtos;
    }

    @Override
    public Map<String, Integer> getMainStatus() {
        HashMap<String, Integer> statusList = new HashMap<>();
        List<TestTask> testTaskBegin = testTaskDao.findByTaskStatus(TestTaskStatusEnums.BEGIN);
        List<TestTask> testTaskNobegin = testTaskDao.findByTaskStatus(TestTaskStatusEnums.NOTBEGIN);
        List<TestTask> testTaskComplete = testTaskDao.findByTaskStatus(TestTaskStatusEnums.COMPLETE);
        statusList.put("begin",testTaskBegin.size());
        statusList.put("wait",testTaskNobegin.size());
        statusList.put("finish",testTaskComplete.size());
        return statusList;
    }

    @Override
    public List<TestTaskDto> findPageTestTask(Pageable pageable) {
        List<TestTask> testTasks = testTaskDao.findAll(pageable).getContent();
        List<TestTaskDto> testTaskDtos = testTasks.parallelStream()
                .map(e->{
                    TestTaskDto testTaskDto = new TestTaskDto();
                    testTaskDto.setTestTask(e);
                    testTaskDto.setCreatAt(e.getCreateDate());
                    try {
                        //获取测试集名称
                        TestDataSet testDataSet = testDatasetDao.findById(e.getTestDatasetId()).orElseThrow(() -> new EntityNotFoundException("未找到该测试任务下的测试集"));
                        testTaskDto.setTestDatasetName(testDataSet.getTestDatasetName());
                        //获取模型名称
                        Model model = modelDao.findById(e.getModelId()).orElseThrow(() -> new EntityNotFoundException("未找到该测试任务下的模型"));
                        testTaskDto.setModelName(model.getModelName());
                    }catch (EntityNotFoundException e1){
                        System.out.println("TestTaskService.findAllTestTask()方法：获取测试任务下的测试集名称Or获取模型名称失败");
                    }
                    testTaskDto.setCreator("central");
                    return testTaskDto;
                }).collect(Collectors.toList());
        return testTaskDtos;
    }

}

