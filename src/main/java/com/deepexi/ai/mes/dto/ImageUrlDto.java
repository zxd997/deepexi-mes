package com.deepexi.ai.mes.dto;

import java.util.Date;

/**
 * @author Lyon
 * @date 2018/11/30 15:36
 * @description ImageUrlDto
 **/
public class ImageUrlDto {

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getGalleryId() {
        return galleryId;
    }

    public void setGalleryId(String galleryId) {
        this.galleryId = galleryId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getImageQuality() {
        return imageQuality;
    }

    public void setImageQuality(Integer imageQuality) {
        this.imageQuality = imageQuality;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Double getRandom() {
        return random;
    }

    public void setRandom(Double random) {
        this.random = random;
    }

    /**
     * 图像文件名
     */
    private String filename;
    /**
     * 图像标签名
     */
    private String label;
    /**
     * 图片所属系列id
     */
    private String seriesId;
    /**
     * 图像所属于数据集id
     */
    private String dataSetId;
    /**
     * 图像所属于数据集id
     */
    private String galleryId;
    /**
     * 图像所处状态 与 MarkStatusEnums关联
     */
    private Integer status;
    /**
     * 图像质量
     */
    private Integer imageQuality;
    /**
     * 图像 oss url
     */
    private String imageUrl;
    /**
     * 创建时间
     */
    private Date createAt;
    /**
     * 随机值
     */
    private Double random;
}
