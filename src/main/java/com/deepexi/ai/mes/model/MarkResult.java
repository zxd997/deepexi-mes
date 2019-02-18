package com.deepexi.ai.mes.model;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Document(collection = "mark_result")
public class MarkResult {
    /**
     * 主键
     */
    @Id
    private String id;
    /**
     * 标记类型信息id
     */
    private String seriesId;
    /**
     * 所属图像id
     */
    private String imageId;
    /**
     * 标记结果列表
     */
    private List<String> result;
    /**
     * 所属上级id
     */
    private String parentId;
    /**
     * 区域异常名称
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
     * 形状类型
     */
    private String shapeType;
    /**
     * 圆心X轴位置
     */
    private Double centerX;
    /**
     * 圆心Y轴位置
     */
    private Double centerY;
    /**
     * 半径
     */
    private Double radius;
    /**
     * 创建时间
     */
    private Date createAt;
    /**
     * 更新时间
     */
    private Date updateAt;

    public MarkResult() {
        this.id = UUID.randomUUID().toString();
        this.createAt = new Date();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public List<String> getResult() {
        return result;
    }

    public void setResult(List<String> result) {
        this.result = result;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
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

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public String getShapeType() {
        return shapeType;
    }

    public void setShapeType(String shapeType) {
        this.shapeType = shapeType;
    }

    public Double getCenterX() {
        return centerX;
    }

    public void setCenterX(Double centerX) {
        this.centerX = centerX;
    }

    public Double getCenterY() {
        return centerY;
    }

    public void setCenterY(Double centerY) {
        this.centerY = centerY;
    }

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }
}
