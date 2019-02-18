package com.deepexi.ai.mes.dto;

/**
 * @Author central
 * @Date 2018/11/19 11:01
 */

public class ImageSeriesDto {
    /**
     * seriesID
     */
    private String id;

    /**
     * 标记名称
     */
    private String seriesName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }
}
