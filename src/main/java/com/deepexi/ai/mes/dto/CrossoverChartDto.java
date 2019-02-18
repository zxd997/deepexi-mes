package com.deepexi.ai.mes.dto;

import io.swagger.models.auth.In;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Lyon
 * @date 2018/12/4 17:38
 * @description CrossoverChartDto
 **/
public class CrossoverChartDto {
    /**
     * 真实图片lebal分类列表
     */
    private List<Map<String,Integer>> labelList;
    /**
     * 预测lebal分类结果列表
     */
    private List<Map<String,Integer>> predList;
    /**
     * 标签总数
     */
    private Integer totalCount;
    /**
     * 所有label名称列表
     */
    private List<String> labels;
    /**
     * 各个label和pred组合出现的次数
     */
    private List<List<Integer>> counts;

    public List<Map<String, Integer>> getLabelList() {
        return labelList;
    }

    public void setLabelList(List<Map<String, Integer>> labelList) {
        this.labelList = labelList;
    }

    public List<Map<String, Integer>> getPredList() {
        return predList;
    }

    public void setPredList(List<Map<String, Integer>> predList) {
        this.predList = predList;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    public List<List<Integer>> getCounts() {
        return counts;
    }

    public void setCounts(List<List<Integer>> counts) {
        this.counts = counts;
    }



}
