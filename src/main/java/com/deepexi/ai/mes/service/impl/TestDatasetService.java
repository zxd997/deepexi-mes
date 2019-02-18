package com.deepexi.ai.mes.service.impl;

import com.deepexi.ai.mes.dao.IImageDao;
import com.deepexi.ai.mes.dao.IMarkResultDao;
import com.deepexi.ai.mes.dao.ITestDatasetDao;
import com.deepexi.ai.mes.dto.*;
import com.deepexi.ai.mes.model.*;
import com.deepexi.ai.mes.service.IImageService;
import com.deepexi.ai.mes.service.ITestDatasetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lyon
 * @date 2018/11/27 14:33
 * @description TestDatasetService
 **/
@Service
public class TestDatasetService implements ITestDatasetService {

    //private final String URI = "http://47.96.191.111:8080";
    private final String URI = "http://localhost:8080";

    @Autowired
    ITestDatasetDao testDatasetDao;

    @Autowired
    IImageDao imageDao;

    @Autowired
    IMarkResultDao markResultDao;

    @Autowired
    IImageService imageService;


//    @Override
//    public TestDataSet createTestDataset(TestDataSet bean)throws Exception{
//        //根据dataSetId调用CMS系统API接口，查询相应的dataSet存入数据库
//        RestTemplate template1 = new RestTemplate();
//        //根据标记类型，调API查询相应的标记任务
//        int markType = bean.getMarkType();
//        ParameterizedTypeReference<List<ImageSeriesDto>> typeRef1 = new ParameterizedTypeReference<List<ImageSeriesDto>>(){};
//        ResponseEntity<List<ImageSeriesDto>> resp1 = template1.exchange(URI +"/api/series?markType="+markType, HttpMethod.GET, null,typeRef1);
//        List<ImageSeriesDto> seriesDtos = resp1.getBody();
//        //根据标记任务id(seriesId)，查询相应的标记结果并存入数据库
//        RestTemplate template2 = new RestTemplate();
//        for(int i=0; i<seriesDtos.size(); i++){
//            String seriesId = seriesDtos.get(i).getId();
//            ParameterizedTypeReference<List<MarkResult>> typeRef2 = new ParameterizedTypeReference<List<MarkResult>>(){};
//            ResponseEntity<List<MarkResult>> resp2 =  template2.exchange(URI +"/api/markResult?seriesId="+seriesId, HttpMethod.GET, null,typeRef2);
//            markResultDao.saveAll(resp2.getBody());
//            //---------------根据seriesId下载图片-------------
//            RestTemplate template = new RestTemplate();
//            ParameterizedTypeReference<List<ImageUrlDto>> typeRef = new ParameterizedTypeReference<List<ImageUrlDto>>(){};
//            ResponseEntity<List<ImageUrlDto>> resp = template.exchange(URI + "/api/markedImage/seriesId?seriesId="+seriesId, HttpMethod.GET, null,typeRef);
//            List<ImageUrlDto> list = resp.getBody();
//            //sortDownloadImages将已标记过的图片按label分类下载到文件夹
//            imageService.sortDownloadImages2(list);
//        }
//        //根据数据集id查找对应的所有图片，并存入数据库
//        RestTemplate template3 = new RestTemplate();
//        DataSetMesDto dataSetMesDto = template3.getForObject(URI +"/api/dataSetMes?dataSetId="+bean.getDataSetId(), DataSetMesDto.class);
//        if(dataSetMesDto!=null){
//            DataSet dataSet = dataSetMesDto.getDataSet();
//            if(dataSet!=null){
//                bean.setImageCount(dataSetMesDto.getImageCount());
//                bean.setDataSetCreator(dataSetMesDto.getCreatorName());
//                bean.setDataSetName(dataSet.getDataSetName());
//                bean.setDataSetCreateAt(dataSet.getCreateAt());
//                testDatasetDao.save(bean);
//                imageDao.saveAll(dataSetMesDto.getImageList());
//            }else{
//                throw new Exception("数据集信息为空！");
//            }
//        }else{
//            throw new Exception("获取数据集失败！");
//        }
//        return bean;
//    }

    /**
     * 根据markType和seriesId创建的新测试集，同时完成以下3项任务：
     * 1.调CMS的API将对应seriesId下的标记结果存入MES数据库
     * 2.下载所有的图片到本地，并根据label分类保存文件夹
     * 3.调CMS的API将seriesId下的图片信息存入MES
     */
    @Override
    public TestDataSet createTestDataset(TestDataSet bean)throws Exception{
        String seriesId = bean.getSeriesId();
        // 1.调CMS的API将对应seriesId下的标记结果存入MES数据库
        RestTemplate template1 = new RestTemplate();
        ParameterizedTypeReference<List<MarkResult>> typeRef1 = new ParameterizedTypeReference<List<MarkResult>>(){};
        ResponseEntity<List<MarkResult>> resp1 =  template1.exchange(URI +"/api/markResult?seriesId="+seriesId, HttpMethod.GET, null,typeRef1);
        markResultDao.saveAll(resp1.getBody());
        // 2.下载所有的图片到本地，并根据label分类保存文件夹
        RestTemplate template2 = new RestTemplate();
        ParameterizedTypeReference<List<ImageUrlDto>> typeRef2 = new ParameterizedTypeReference<List<ImageUrlDto>>(){};
        ResponseEntity<List<ImageUrlDto>> resp2 = template2.exchange(URI + "/api/markedImage?seriesId="+seriesId, HttpMethod.GET, null,typeRef2);
        List<ImageUrlDto> list = resp2.getBody();
        imageService.sortDownloadImages2(list);
        // 3.调CMS的API将seriesId下的图片信息存入MES
        RestTemplate template3 = new RestTemplate();
        ParameterizedTypeReference<List<Image>> typeRef3 = new ParameterizedTypeReference<List<Image>>(){};
        ResponseEntity<List<Image>> resp3 = template3.exchange(URI + "/api/image?seriesId="+seriesId, HttpMethod.GET, null,typeRef3);
        imageDao.saveAll(resp3.getBody());
        //设置测试集属性
        RestTemplate template4 = new RestTemplate();
        ParameterizedTypeReference<List<String>> typeRef4 = new ParameterizedTypeReference<List<String>>(){};
        ResponseEntity<List<String>> resp4 = template4.exchange(URI +"/api/datasetIds?seriesId=" + seriesId, HttpMethod.GET, null,typeRef4);
        bean.setDataSetIdList(resp4.getBody());
        List<LabelCountDto> labelIfoList = bean.getLabelInfoList();
        int total = 0;
        for(int i=0; i<labelIfoList.size(); i++){
            total+=labelIfoList.get(i).getAmount();
        }
        bean.setImageCount(total);
        testDatasetDao.save(bean);
        return bean;
    }

    @Override
    public void deleteTestDataset(String testDatasetId) {
        testDatasetDao.deleteById(testDatasetId);
    }

    @Override
    public List<TestDataSet> findAllTestDataset() {
        return testDatasetDao.findAll();
    }

    @Override
    public Page<TestDataSet> findAllTestDatasetByPageQuery(Pageable pageable){
        Page<TestDataSet> page = testDatasetDao.findAll(pageable);
        return page;
    }

    @Override
    public List<TestDataSet> findAllTestDataset(Pageable pageable){
        List<TestDataSet> list = testDatasetDao.findAll(pageable).getContent();
        return list;
    }
}

