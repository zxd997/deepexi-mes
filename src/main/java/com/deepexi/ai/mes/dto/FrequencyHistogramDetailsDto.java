package com.deepexi.ai.mes.dto;

import java.util.List;

/**
 * 显示频率分布直方图的所有信息
 */
public class FrequencyHistogramDetailsDto {
    /**
     * 每条的信息
     */
    private List<FrequencyHistogramDto> frequencyHistogramDtoList;
    /**
     * 平均值
     */
    private Double avg;
    /**
     * 标准差
     */
    private Double standardDeviation;
    /**
     * 个案数
     */
    private Integer num;

    public List<FrequencyHistogramDto> getFrequencyHistogramDtoList() {
        return frequencyHistogramDtoList;
    }

    public void setFrequencyHistogramDtoList(List<FrequencyHistogramDto> frequencyHistogramDtoList) {
        this.frequencyHistogramDtoList = frequencyHistogramDtoList;
    }

    public Double getAvg() {
        return avg;
    }

    public void setAvg(Double avg) {
        this.avg = avg;
    }

    public Double getStandardDeviation() {
        return standardDeviation;
    }

    public void setStandardDeviation(Double standardDeviation) {
        this.standardDeviation = standardDeviation;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
