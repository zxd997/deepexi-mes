package com.deepexi.ai.mes.dao;

import com.deepexi.ai.mes.model.Image;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;


/**
 * @author lyon
 * @date   2018/11/30 11:23
 * @detail 图片接口DAO层
 */
public interface IImageDao extends MongoRepository<Image, String> {
    /**
     * 根据id查询图片。可用fileds指定要返回的字段，如：
     * '@Query(fields="{'_id':1,'filename':1,'dataSetId':1}")'
     * @param id
     */
    Image findImageById(String id);
    /**
     * 根据seriesId查询对应图片的文件名
     * @param seriesId
     */
    @Query(fields="{'_id':1,'filename':1}")
    List<Image> findImagesBySeriesId(String seriesId);
    /**
     * 根据dataSetId查询对应数据集下所有图片
     * @param dataSetId
     */
    //findDistinctByDataSetId
    List<Image> findImagesByDataSetId(String dataSetId);
}
