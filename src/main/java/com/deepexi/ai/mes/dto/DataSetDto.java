package com.deepexi.ai.mes.dto;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 用来传输给持续科研系统数据集的数据结构
 */
public class DataSetDto {

    /**
     * 数据集名称
     */
    private String dataSetName;

    /**
     * 各个标签对应的图像信息
     */
    private ConcurrentHashMap<String, List<ImageResponseDto>> imageMap;


    public String getDataSetName() {
        return dataSetName;
    }

    public void setDataSetName(String dataSetName) {
        this.dataSetName = dataSetName;
    }

    public ConcurrentHashMap<String, List<ImageResponseDto>> getImageMap() {
        return imageMap;
    }

    public void setImageMap(ConcurrentHashMap<String, List<ImageResponseDto>> imageMap) {
        this.imageMap = imageMap;
    }
}
