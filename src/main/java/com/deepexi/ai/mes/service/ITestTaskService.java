package com.deepexi.ai.mes.service;

import com.deepexi.ai.mes.dto.TestTaskDto;
import com.deepexi.ai.mes.dto.TestTaskPostDto;
import com.deepexi.ai.mes.dto.TestTaskRequestDto;
import com.deepexi.ai.mes.model.TestTask;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

/**
 * @author lyon
 * @date   2018/12/5 11:15
 * @detail 测试任务Service接口
 */
public interface ITestTaskService {
    /**
     * 创建新测试任务
     */
    TestTaskPostDto createTestingTask(TestTaskPostDto testTaskPostDto) throws Exception;
    /**
     * 查看测试任务详情
     */
    TestTaskRequestDto getTestTaskDetail(String testTaskId)throws Exception;
    /**
     * 根据模型Id获取该模型下的测试任务列表
     */
    TestTaskRequestDto getModelTestTaskList(String modelId,String testDatasetId);
    /**
     * 获取全部测试任务列表
     */
    List<TestTaskDto> findAllTestTask();
    /**
     * 主页获取运行中任务,队列中任务,已完成任务个数
     */
    Map<String, Integer> getMainStatus();

    List<TestTaskDto> findPageTestTask(Pageable pageable);
}
