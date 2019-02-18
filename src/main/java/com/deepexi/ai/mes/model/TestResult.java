package com.deepexi.ai.mes.model;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.List;
import java.util.UUID;

/**@Author Zxd
 * 测试结果结构
 */
@Document
public class TestResult {
    @Id
    private String id;
    private String filename;
    private String labels;
    private Double possibility;
    private String pred;
    private Integer true_or_false;
    private String taskId;
    /**
     * 对应的权重id
     */
    private String weightId;

    public TestResult() {
        this.id = UUID.randomUUID().toString();
        this.taskId = UUID.randomUUID().toString();
        this.weightId="weightId";
    }

    public String getWeightId() {
        return weightId;
    }

    public void setWeightId(String weightId) {
        this.weightId = weightId;
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

    public Double getPossibility() {
        return possibility;
    }

    public void setPossibility(Double possibility) {
        this.possibility = possibility;
    }

    public Integer getTrue_or_false() {
        return true_or_false;
    }

    public void setTrue_or_false(Integer true_or_false) {
        this.true_or_false = true_or_false;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels.get(0);
    }

    public String getPred() {
        return pred;
    }

    public void setPred(List<String> pred) {
        this.pred = pred.get(0);
    }
}
