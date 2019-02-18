package com.deepexi.ai.mes.dto;

import java.util.Date;

/**
 * @Author central
 * @Description 传输给csrs的图像数据结构
 * @Date 2018/11/20 10:06
 */
public class ImageResponseDto {

    /**
     * 所属标记系列Id
     */
    private String seriesId;

    /**
     * 图像id
     */
    private String imageId;

    /**
     * 所属数据集Id
     */
    private String dataSetId;

    /**
     * 文件名
     */
    private String filename;

    /**
     * 标签类型
     */
    private String label;

    /**
     * X轴位置
     */
    private Double x;

    /**
     * Y轴位置
     */
    private Double y;

    /**
     * 高度
     */
    private Double height;

    /**
     * 宽度
     */
    private Double width;

    /**
     * 创建日期
     */
    private Date createAt;

    public String getDataSetId() {
        return dataSetId;
    }

    public void setDataSetId(String dataSetId) {
        this.dataSetId = dataSetId;
    }

    public String getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(String seriesId) {
        this.seriesId = seriesId;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}
