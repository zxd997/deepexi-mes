package com.deepexi.ai.mes.dto;


import io.swagger.annotations.ApiModel;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 用来接受CSRS数据集的请求结构
 */
@ApiModel(value="DataSetRequestDto对象",description="数据集请求Dto对象，")
public class DataSetRequestDto {
    /**
     * 标记系列 id
     */
    @ApiModelProperty(value="cms中的标记任务ID",name="seriesId",example="5b4b8acf-df25-4fd7-bf74-00ad28d7b977")
    private String seriesId;
    /**
     * 数据集id
     */
    @ApiModelProperty(value="数据集ID",name="dataSetId",required=false)
    private String dataSetId;
    /**
     * 数据集名称
     */
    @ApiModelProperty(value="创建的数据集名称",name="dataSetName",example="数据集示例")
    private String dataSetName;
    /**
     * 各个标记类型所需要的数量
     */
    private List<LabelCountDto> labelInfoList;

    public String getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(String seriesId) {
        this.seriesId = seriesId;
    }

    public String getDataSetId() {
        return dataSetId;
    }

    public void setDataSetId(String dataSetId) {
        this.dataSetId = dataSetId;
    }

    public String getDataSetName() {
        return dataSetName;
    }

    public void setDataSetName(String dataSetName) {
        this.dataSetName = dataSetName;
    }

    public List<LabelCountDto> getLabelInfoList() {
        return labelInfoList;
    }

    public void setLabelInfoList(List<LabelCountDto> labelInfoList) {
        this.labelInfoList = labelInfoList;
    }
}
