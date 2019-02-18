package com.deepexi.ai.mes.model;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.UUID;

/**
 * @author Zxd
 *  权重
 **/
@Document
public class Weight {
    /**
     * 主键
     */
    @Id
    private String id;
    /**
     * 对应的Model ID
     */
    private String modelId;
    /**
     * 权重名字
     */
    private String weightName;

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public Weight() {
        this.id= UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWeightName() {
        return weightName;
    }

    public void setWeightName(String weightName) {
        this.weightName = weightName;
    }
}
