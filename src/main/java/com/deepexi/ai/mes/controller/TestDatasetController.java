package com.deepexi.ai.mes.controller;

import com.deepexi.ai.mes.dto.ResponseDto;
import com.deepexi.ai.mes.model.TestDataSet;
import com.deepexi.ai.mes.service.IImageService;
import com.deepexi.ai.mes.service.IMarkResultService;
import com.deepexi.ai.mes.service.impl.TestDatasetService;
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

import java.util.List;

/**
 * @author Lyon
 * @date 2018/11/27 13:52
 * @description TestDataSetController
 **/
@RestController
@Api(value = "测试集controller", tags = {"测试集操作接口"})
@RequestMapping("/testDataset")
public class TestDatasetController {

    private final String URI = "http://47.96.191.111:8080";
    //private final String URI = "http://localhost:8080";

    @Autowired
    TestDatasetService testDatasetService;

    @Autowired
    IMarkResultService markResultService;

    @Autowired
    IImageService imageService;

    @ApiOperation("创建一个新测试集")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "testDataSet", dataType = "TestDataSet", required = true, value = "测试集实体对象")
    })
    @PostMapping("/create")
    public ResponseDto createTestDateset(@RequestBody TestDataSet testDataSet)throws Exception{
        TestDataSet result = testDatasetService.createTestDataset(testDataSet);
        return ResultUtil.getResult(result);
    }

    @ApiOperation("删除一个测试集")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "testDatasetId", dataType = "String", required = true, value = "测试集ID", defaultValue = "723b23c2-483f-4c71-a9a9-46f3f0e77008")
    })
    @GetMapping("/delete")
    public ResponseDto deleteTestDateset(String testDatasetId){
        testDatasetService.deleteTestDataset(testDatasetId);
        return ResultUtil.getResult("删除成功!");
    }

    @ApiOperation("获取所有测试集(不分页)")
    @GetMapping("/listAll")
    public ResponseDto getAllTestDataset(){
        List<TestDataSet> testDataSets = testDatasetService.findAllTestDataset();
        return ResultUtil.getResult(testDataSets);
    }

    @ApiOperation("获取所有测试集(分页)")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "page", dataType = "int", required = true, value = "当前页", defaultValue = "0"),
            @ApiImplicitParam(paramType = "query", name = "size", dataType = "int", required = true, value = "每页数量", defaultValue = "10")
    })
    @GetMapping("/page")
    public ResponseDto getPageTestDataset(Integer page, Integer size) throws Exception {
        page = page == null ? 0 : page;
        size = size == null ? 10 : size;
        PageRequest pageRequest = PageRequest.of(page, size);
        List<TestDataSet> testDataSetList = testDatasetService.findAllTestDataset(pageRequest);
        Page<TestDataSet> dataSetPage = new PageImpl<>(testDataSetList,pageRequest,testDataSetList.size());
        return ResultUtil.getResult(dataSetPage);
    }

}
