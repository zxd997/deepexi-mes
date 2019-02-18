package com.deepexi.ai.mes.controller;

import com.deepexi.ai.mes.dto.ResponseDto;
import com.deepexi.ai.mes.dto.TestTaskDto;
import com.deepexi.ai.mes.dto.TestTaskPostDto;
import com.deepexi.ai.mes.dto.TestTaskRequestDto;
import com.deepexi.ai.mes.model.TestDataSet;
import com.deepexi.ai.mes.model.TestResult;
import com.deepexi.ai.mes.model.TestTask;
import com.deepexi.ai.mes.service.impl.TestResultService;
import com.deepexi.ai.mes.service.impl.TestTaskService;
import com.deepexi.ai.mes.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

/**
 * @author lyon
 * @date   2018/12/5 10:47
 * @detail 测试任务Controller
 */
@RestController
@Api(value = "测试任务Controller", tags = {"测试任务操作接口"})
@RequestMapping("/testTask")
public class TestTaskController {

    @Autowired
    TestTaskService testTaskService;

    @Autowired
    TestResultService testResultService;

    @ApiOperation("创建一个测试任务")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "body", name = "testTaskPostDto", dataType = "TestTaskPostDto", required = true, value = "测试任务创建Dto"),
    })
    @PostMapping("/create")
    public ResponseDto createTestingTask(@RequestBody TestTaskPostDto testTaskPostDto) throws Exception {
        TestTaskPostDto result = testTaskService.createTestingTask(testTaskPostDto);
        return ResultUtil.getResult(result);
    }

    @ApiOperation("查看所有测试任务(不分页)")
    @GetMapping("/listAll")
    public ResponseDto getAllPageTestTask(){
        List<TestTaskDto> testTaskDtos = testTaskService.findAllTestTask();
        return ResultUtil.getResult(testTaskDtos);
    }

    @ApiOperation("查看所有测试任务(分页)")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "page", dataType = "int", required = true, value = "当前页", defaultValue = "0"),
            @ApiImplicitParam(paramType = "query", name = "size", dataType = "int", required = true, value = "每页数量", defaultValue = "10")
    })
    @GetMapping("/page")
    public ResponseDto getPageTestTask(Integer size,Integer page){
        page = page == null ? 0 : page;
        size = size == null ? 10 : size;
        PageRequest pageRequest = PageRequest.of(page, size);
        List<TestTaskDto> testTaskDtos = testTaskService.findPageTestTask(pageRequest);
        Page<TestTaskDto> testTaskDtoPage = new PageImpl<>(testTaskDtos,pageRequest,testTaskDtos.size());
        return ResultUtil.getResult(testTaskDtoPage);
    }

    @ApiOperation("根据测试任务Id获取任务详情")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "testTaskId", dataType = "string", required = true, value = "测试任务Id", defaultValue = "a95734b1-341b-4030-9c86-6efc9a032d03")
    })
    // todo
    @GetMapping("/detail")
    public ResponseDto getTestTaskDetail(String testTaskId) throws Exception {
        TestTaskRequestDto result = testTaskService.getTestTaskDetail(testTaskId);
        return ResultUtil.getResult(result);
    }

    @ApiOperation("根据modelId测试集id和获取任务详情")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "modelId", dataType = "string", required = true, value = "模型ID", defaultValue = "e5cc753b-f8d7-40b8-b825-598c356a4dbd"),
            @ApiImplicitParam(paramType = "query", name = "testDatasetId", dataType = "string", required = true, value = "测试集ID", defaultValue = "33f14cce-d63b-4149-a6d6-4456a1c28d70")
    })
    @GetMapping("/testTaskDetail")
    public ResponseDto getModelList(String modelId,String testDatasetId){
        TestTaskRequestDto dto = testTaskService.getModelTestTaskList(modelId,testDatasetId);
        return ResultUtil.getResult(dto);
    }

    @ApiOperation("主页获取运行中任务,队列中任务,已完成任务个数")
    @GetMapping("/status")
    public ResponseDto getMainStatus(){
        Map<String,Integer> mainStatus = testTaskService.getMainStatus();
        return ResultUtil.getResult(mainStatus);
    }
}
