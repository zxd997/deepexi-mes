package com.deepexi.ai.mes.controller;

import com.deepexi.ai.mes.dto.ImportModelDto;
import com.deepexi.ai.mes.dto.ResponseDto;
import com.deepexi.ai.mes.model.Model;
import com.deepexi.ai.mes.service.impl.ModelService;
import com.deepexi.ai.mes.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;


/**
 * @Author Zxd
 */
@RestController
@RequestMapping("/models")
@Api(value = "模型controller", tags = {"模型操作接口"})
public class ModelController {

    @Autowired
    ModelService modelService;

    @ApiOperation("导入模型")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "body", name = "importModelDto", dataType = "ImportModelDto", required = true, value = "导入模型Dto"),
    })
    @PostMapping("/import")
    public ResponseDto importModel(@RequestBody ImportModelDto importModelDto){
        Model model = modelService.importModel(importModelDto.getName());
        return ResultUtil.getResult(model);
    }
    @ApiOperation("获取模型列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "page", dataType = "int", required = true, value = "当前页", defaultValue = "0"),
            @ApiImplicitParam(paramType = "query", name = "size", dataType = "int", required = true, value = "每页数量", defaultValue = "10")
    })
    @GetMapping("/list")
    public ResponseDto getModelList(Integer page, Integer size){
        page = page == null ? 0: page;
        size = size == null ? 10 : size;
        Pageable pageable = PageRequest.of(page, size,new Sort(Sort.Direction.DESC, "createAt"));
        Page<Model> ModelPageList = modelService.findAllModel(pageable);
        return ResultUtil.getResult(ModelPageList);
    }
}
