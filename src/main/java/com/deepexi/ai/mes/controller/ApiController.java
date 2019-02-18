package com.deepexi.ai.mes.controller;

import com.deepexi.ai.mes.dto.DataSetRequestDto;
import com.deepexi.ai.mes.dto.ImageSeriesDto;
import com.deepexi.ai.mes.dto.ImageUrlDto;
import com.deepexi.ai.mes.dto.ResponseDto;
import com.deepexi.ai.mes.model.Image;
import com.deepexi.ai.mes.model.MarkResult;
import com.deepexi.ai.mes.service.IImageService;
import com.deepexi.ai.mes.service.IMarkResultService;
import com.deepexi.ai.mes.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Lyon
 * @date 2018/11/27 17:35
 * @description ApiController
 **/
@RestController
@Api(value = "对外接口controller", tags = {"提供给其他系统接口"})
@RequestMapping(path = "/api")
public class ApiController {

    //private final String URI = "http://192.168.3.124:8050";
    private final String URI = "http://localhost:8080";

    @Autowired
    IMarkResultService markResultService;

    @Autowired
    IImageService imageService;

//    @ApiOperation("获取标记类型对应的可选数据集列表")
//    @ApiImplicitParams({
//            @ApiImplicitParam(paramType = "query", name = "markType", dataType = "int", required = true, value = "标记类型", defaultValue = "0")
//    })
//    @GetMapping(path = "/series")
//    public ResponseDto getImageSeries(Integer markType)throws Exception {
//        RestTemplate template = new RestTemplate();
//        ParameterizedTypeReference<List<ImageSeriesDto>> typeRef = new ParameterizedTypeReference<List<ImageSeriesDto>>(){};
//        ResponseEntity<List<ImageSeriesDto>> resp = template.exchange(URI + "/api/series?markType="+markType, HttpMethod.GET, null,typeRef);
//        List<ImageSeriesDto> seriesDtos = resp.getBody();
//        List<DataSetRequestDto> dtos = new ArrayList<>();
//        for(int i=0; i<seriesDtos.size(); i++){
//            String seriesId = seriesDtos.get(i).getId();
//            ResponseDto result = new RestTemplate().getForObject(URI + "/api/dataSetDtos?seriesId="+seriesId, ResponseDto.class);
//            dtos.addAll((List<DataSetRequestDto>)result.getData());
//        }
//
//        return ResultUtil.getResult(dtos);
//    }

    @ApiOperation("获取markType对应可选的标记系列任务")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "markType", dataType = "int", required = true, value = "标记类型", defaultValue = "0")
    })
    @GetMapping(path = "/series")
    public ResponseDto getImageSeries(Integer markType)throws Exception {
        RestTemplate template = new RestTemplate();
        ParameterizedTypeReference<List<ImageSeriesDto>> typeRef = new ParameterizedTypeReference<List<ImageSeriesDto>>(){};
        ResponseEntity<List<ImageSeriesDto>> resp = template.exchange(URI + "/api/series?markType="+markType, HttpMethod.GET, null,typeRef);
        List<ImageSeriesDto> seriesDtos = resp.getBody();
        return ResultUtil.getResult(seriesDtos);
    }

    @ApiOperation("获取标记系列下各个label的标记数量")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "seriesId", dataType = "String", required = true, value = "标记任务ID", defaultValue = "76a03706-6f59-492a-b63c-c39b0f7c2d3b")
    })
    @GetMapping(path = "/label")
    public ResponseDto getLabelInfo(String seriesId) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseDto result = restTemplate.getForObject(URI + "/api/label?seriesId="+seriesId,ResponseDto.class);
        return result;
    }

    @ApiOperation("调用CMS系统API，生成数据集并查询标记结果集(MarkResult)，将其存入MES数据库")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "body", name = "dataSetRequestDto", dataType = "DataSetRequestDto", required = true, value = "数据集请求DTO")
    })
    @PostMapping(path = "/generateDataSet")
    public ResponseDto generateDataSet(@RequestBody DataSetRequestDto dataSetRequestDto) {
        String seriesId = dataSetRequestDto.getSeriesId();
        RestTemplate template1 = new RestTemplate();
        ResponseDto result = template1.postForObject(URI + "/api/generateDataSet", dataSetRequestDto, ResponseDto.class);
        RestTemplate template2 = new RestTemplate();
        ParameterizedTypeReference<List<MarkResult>> typeRef = new ParameterizedTypeReference<List<MarkResult>>(){};
        ResponseEntity<List<MarkResult>> resp = template2.exchange(URI + "/api/markResult?seriesId="+seriesId, HttpMethod.GET, null,typeRef);
        List<MarkResult> list = resp.getBody();
        markResultService.saveAll(list);
        return result;
    }

    @ApiOperation("根据dataSetId获取数据集信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "dataSetId", dataType = "String", required = true, value = "数据集ID", defaultValue = "723b23c2-483f-4c71-a9a9-46f3f0e77008")
    })
    @GetMapping(path = "/dataSet")
    public ResponseDto getDataSet(String dataSetId){
        RestTemplate restTemplate = new RestTemplate();
        ResponseDto result = restTemplate.getForObject(URI +"/api/dataSet?dataSetId="+dataSetId, ResponseDto.class);
        return result;
    }

    @ApiOperation("根据seriesId获取可选数据集")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "seriesId", dataType = "String", required = true, value = "标记系列ID", defaultValue = "c5f263ed-4d76-4c7d-bffe-44364338c51e")
    })
    @GetMapping(path = "/dataSetIds")
    public ResponseDto getDataSetIds(String seriesId) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        ResponseDto result = restTemplate.getForObject(URI +"/api/dataSetIds?seriesId="+seriesId, ResponseDto.class);
        return result;
    }

    @ApiOperation("根据seriesId获取相应标记结果集")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "seriesId", dataType = "String", required = true, value = "标记任务ID", defaultValue = "5b4b8acf-df25-4fd7-bf74-00ad28d7b977")
    })
    @GetMapping(path = "/markResult")
    public ResponseDto getMarkResult(String seriesId){
        RestTemplate restTemplate = new RestTemplate();
        ResponseDto result = restTemplate.getForObject(URI +"/api/markResult?seriesId="+seriesId, ResponseDto.class);
        return result;
    }

    @ApiOperation("根据seriesId获取相应图片")
    @GetMapping(path = "/image/seriesId")
    public ResponseDto getImagesBySeriesId(String seriesId) throws Exception {
        RestTemplate template = new RestTemplate();
        ParameterizedTypeReference<List<Image>> typeRef = new ParameterizedTypeReference<List<Image>>(){};
        ResponseEntity<List<Image>> resp = template.exchange(URI + "/api/image/seriesId?seriesId="+seriesId, HttpMethod.GET, null,typeRef);
        return ResultUtil.getResult(resp.getBody());
    }

    @ApiOperation("根据seriesId获取已标注图片，并按label分类下载到服务器")
    @GetMapping(path = "/markedImage/seriesId")
    public ResponseDto getMarkedImagesBySeriesId(String seriesId, HttpServletRequest request) throws Exception {
        RestTemplate template = new RestTemplate();
        ParameterizedTypeReference<List<ImageUrlDto>> typeRef = new ParameterizedTypeReference<List<ImageUrlDto>>(){};
        ResponseEntity<List<ImageUrlDto>> resp = template.exchange(URI + "/api/markedImage/seriesId?seriesId="+seriesId, HttpMethod.GET, null,typeRef);
        List<ImageUrlDto> list = resp.getBody();
        //将已标记过的图片按label分类下载到文件夹
        imageService.sortDownloadImages(list,request);
        return ResultUtil.getResult(list);
    }
}

