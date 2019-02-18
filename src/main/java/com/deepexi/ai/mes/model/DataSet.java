package com.deepexi.ai.mes.model;

import com.deepexi.ai.mes.enums.DataSetLoadStatusEnums;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.UUID;

/**
 * @Author Cason
 * @Date 2018/10/31
 */
@Document(collection = "data_set")
public class DataSet {

    @Id
    private String id;
    /**
     * 数据集名称
     */
    private String dataSetName;
    /**
     * 预留ID，用户ID,上传者ID
     */
    private String creatorId;
    /**
     * 预留字段，用户组ID
     */
    private String departmentId;
    /**
     * oss bucket 名称
     */
    private String bucketName;
    /**
     * 端点
     */
    private String endPoint;
    /**
     * keyId
     */
    private String accessKeyId;
    /**
     * keySecret
     */
    private String accessKeySecret;
    /**
     * 数据集加载状态 0加载中 2就绪
     */
    private Integer status;
    /**
     * 创建日期
     */
    private Date createAt;

    public DataSet() {
        this.id = UUID.randomUUID().toString();
        this.createAt = new Date();
        this.status = DataSetLoadStatusEnums.LOADING;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDataSetName() {
        return dataSetName;
    }

    public void setDataSetName(String dataSetName) {
        this.dataSetName = dataSetName;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public String getAccessKeySecret() {
        return accessKeySecret;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}
