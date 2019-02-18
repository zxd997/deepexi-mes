package com.deepexi.ai.mes.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.UUID;

@Document
public class MockResult {
    @Id
    private String id;
    /**
     * 对应的MetaResult的Id
     */
    private  String metaResultId;
    /**
     * 文件名
     */
    private String filename;
    /**
     * 适配标签值
     */
    private String label;
    /**
     * 正类可能性
     */
    private Double possibility;
    /**
     * 是否为真实标签
     */
    private Integer flag;
    /**
     * 任务id
     */
    private String taskId;

    /**
     * 权重id
     */
    private String weightId;
    /**
     * 模型id
     */
    private String modelId;

    public MockResult() {
        this.id = UUID.randomUUID().toString();
        this.taskId = UUID.randomUUID().toString();
        this.weightId = "weightId";
        this.modelId = "modelId";
    }

    public String getMetaResultId() {
        return metaResultId;
    }

    public void setMetaResultId(String metaResultId) {
        this.metaResultId = metaResultId;
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

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Double getPossibility() {
        return possibility;
    }

    public void setPossibility(Double possibility) {
        this.possibility = possibility;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getWeightId() {
        return weightId;
    }

    public void setWeightId(String weightId) {
        this.weightId = weightId;
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }
}
