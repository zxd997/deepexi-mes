package com.deepexi.ai.mes.dto;

public class FrequencyHistogramDto {
    /**
     * 区域左端点
     */
    private Double xLeft;
    /**
     * 区域右端点
     */
    private Double xRight;
    /**
     * 频数
     */
    private Integer frequency;

    public FrequencyHistogramDto(Double xLeft, Double xRight, Integer frequency) {
        this.xLeft = xLeft;
        this.xRight = xRight;
        this.frequency = frequency;
    }

    public FrequencyHistogramDto() {
    }

    public Double getxLeft() {
        return xLeft;
    }

    public void setxLeft(Double xLeft) {
        this.xLeft = xLeft;
    }

    public Double getxRight() {
        return xRight;
    }

    public void setxRight(Double xRight) {
        this.xRight = xRight;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }
}
