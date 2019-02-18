package com.deepexi.ai.mes.dto;

import com.deepexi.ai.mes.model.TestTask;
import com.deepexi.ai.mes.model.TestTaskDetail;

import java.util.Date;
import java.util.List;

/**
 * @author lyon
 * @date   2018/12/5 11844
 * @detail 测试任务Dto(用于列表展示测试任务)
 */
public class TestTaskDto {

    private TestTask testTask;

    private String modelName;

    private String weightCount;

    private String testDatasetName;

    private String creator;

    private Date creatAt;

    public TestTask getTestTask() {
        return testTask;
    }

    public void setTestTask(TestTask testTask) {
        this.testTask = testTask;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getWeightCount() {
        return weightCount;
    }

    public void setWeightCount(String weightCount) {
        this.weightCount = weightCount;
    }

    public String getTestDatasetName() {
        return testDatasetName;
    }

    public void setTestDatasetName(String testDatasetName) {
        this.testDatasetName = testDatasetName;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getCreatAt() {
        return creatAt;
    }

    public void setCreatAt(Date creatAt) {
        this.creatAt = creatAt;
    }

}
