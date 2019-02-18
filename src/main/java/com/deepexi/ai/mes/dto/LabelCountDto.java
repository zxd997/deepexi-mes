package com.deepexi.ai.mes.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Author central
 * @Date 2018/11/19 11:06
 */

public class LabelCountDto {

    /**
     * 标签名称
     */
    @ApiModelProperty(value="数据集的标签名称",name="labelName",example="区域1")
    private String labelName;
    /**
     * 标签下的图像数量
     */
    @ApiModelProperty(value="该标签对应的图像数量",name="amount",example="5")
    private Integer amount;


    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
