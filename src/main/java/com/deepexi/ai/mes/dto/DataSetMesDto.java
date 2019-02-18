package com.deepexi.ai.mes.dto;

import com.deepexi.ai.mes.model.DataSet;
import com.deepexi.ai.mes.model.Image;

import java.util.List;

/**
 * @Author Lyon
 * @Date 2018/11/30
 */
public class DataSetMesDto {
    /**
     * 数据集实体
     */
    private DataSet dataSet;
    /**
     * 包含图片数
     */
    private Integer imageCount;
    /**
     * 创建者名称
     */
    private String creatorName;
    /**
     * 数据集所对应的全部图片
     */
    private List<Image> imageList;

    public DataSet getDataSet() {
        return dataSet;
    }

    public void setDataSet(DataSet dataSet) {
        this.dataSet = dataSet;
    }

    public Integer getImageCount() {
        return imageCount;
    }

    public void setImageCount(Integer imageCount) {
        this.imageCount = imageCount;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public List<Image> getImageList() {
        return imageList;
    }

    public void setImageList(List<Image> imageList) {
        this.imageList = imageList;
    }
}
