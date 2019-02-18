package com.deepexi.ai.mes.model;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.Date;
import java.util.UUID;

/**
 * 模型文件结构
 */
@Document
public class Model {
    @Id
    private String id;
    /**
     * 模型名称（前端传进来的）
     */
    private String name;
    /**
     * 模型配置文件名
     */
    private String modelName;
    /**
     * 模型配置文件路径
     */
    private String path;
    /**
     * 创建时间
     */
    private Date createAt;
    /**
     * 创建id
     */
    private String creatorId;
    /**
     * 创建模型的名字（暂时写死）
     */
    private String creatorName;

    public Model() {
        this.id= UUID.randomUUID().toString();
        this.creatorId=UUID.randomUUID().toString();
        this.createAt=new Date();
        this.creatorName="滴普";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }
}
