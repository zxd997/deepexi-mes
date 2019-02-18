package com.deepexi.ai.mes.model;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.UUID;

/**
 * @Author Zxd
 * 单条结果标志
 */
@Document
public class MetaResult {

    @Id
    private String id;
    /**
     * 文件名
     */
    private String filename;
    /**
     * 真实标签值
     */
    private String label;
    /**
     * 权重id
     */
    private String weightId;
    /**
     * 模型id
     */
    private String modelId;

    public MetaResult() {
        this.id = UUID.randomUUID().toString();
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
