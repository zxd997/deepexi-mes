package com.deepexi.ai.mes.model;


import com.deepexi.ai.mes.enums.ImageQualityEnums;
import com.deepexi.ai.mes.enums.MarkStatusEnums;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.Date;
import java.util.UUID;

@Document(collection = "image")
public class Image {
    /**
     * 主键
     */
    @Id
    private String id;
    /**
     * 图像文件名
     */
    private String filename;
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

    public Image() {
        this.id = UUID.randomUUID().toString();
        this.imageQuality = ImageQualityEnums.GOOD;
        this.status = MarkStatusEnums.UNMARKED;
        this.createAt = new Date();
        this.random = Math.random();
    }

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

    public Integer getStatus() {
        return status;
    }

    public String getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(String seriesId) {
        this.seriesId = seriesId;
    }

    public String getGalleryId() {
        return galleryId;
    }

    public void setGalleryId(String galleryId) {
        this.galleryId = galleryId;
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

    public String getDataSetId() {
        return dataSetId;
    }

    public void setDataSetId(String dataSetId) {
        this.dataSetId = dataSetId;
    }

    public Double getRandom() {
        return random;
    }

    public void setRandom(Double random) {
        this.random = random;
    }
}
