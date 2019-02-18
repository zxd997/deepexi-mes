package com.deepexi.ai.mes.controller;

import com.deepexi.ai.mes.dto.CrossoverChartDto;
import com.deepexi.ai.mes.dto.FrequencyHistogramDetailsDto;
import com.deepexi.ai.mes.dto.ResponseDto;
import com.deepexi.ai.mes.model.TestResult;
import com.deepexi.ai.mes.service.IMockResultService;
import com.deepexi.ai.mes.service.ITestResultService;
import com.deepexi.ai.mes.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Zxd
 **/
@Api(value = "测试结果controller", tags = {"测试结果操作接口"})
@RequestMapping("/test")
@RestController
public class TestResultController {

    @Autowired
    ITestResultService testResultService;
    @Autowired
    IMockResultService mockResultService;

    @ApiOperation("测试结果存到数据库")
    @PostMapping("/result")
    public ResponseDto uploadTestResult(@RequestBody List<TestResult> testResultList ) throws Exception {
        testResultService.save(testResultList);
        return ResultUtil.getResult(testResultList.size());
    }

    @ApiOperation("测试结果分析的直方图")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "weightId", dataType = "String", required = true, value = "权重id", defaultValue = "weightId"),
    })
    @GetMapping("/details/frequencyHistogram")
    public ResponseDto getFrequencyHistogram(String weightId){
        FrequencyHistogramDetailsDto frequencyHistogramDetailsDto = testResultService.getFrequencyHistogram(weightId);
        return ResultUtil.getResult(frequencyHistogramDetailsDto);
    }

    @ApiOperation("测试结果交叉图")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "weightId", dataType = "String", required = true, value = "权重id", defaultValue = "weightId"),
    })
    @GetMapping("/details/crossover")
    public ResponseDto getCrossoverChart(String weightId) {
        CrossoverChartDto crossoverChartDto = testResultService.getCrossoverChart(weightId);
        return ResultUtil.getResult(crossoverChartDto);
    }

    @GetMapping("/details/roc")
    public ResponseDto getRocChart(){
        Double[][] roc = mockResultService.createRoc();
        return ResultUtil.getResult(roc);
    }
}
