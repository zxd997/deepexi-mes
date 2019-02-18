package com.deepexi.ai.mes.dto;

import com.deepexi.ai.mes.model.TestTask;
import com.deepexi.ai.mes.model.TestTaskDetail;

import java.util.Date;
import java.util.List;

/**
 * @author lyon
 * @date   2018/12/5 11:44
 * @detail 测试任务创建页面Dto实体
 */
public class TestTaskRequestDto {
    /**
     * 测试任务实体
     */
    private TestTask testTask;
    /**
     * 测试任务实体
     */
    private List<TestTaskDetail> testTaskDetails;
    /**
     * 测试集名称
     */
    private String testDatasetName;
    /**
     * 模型名称
     */
    private String modelName;
    /**
     * 测试任务创建人
     */
    private String testTaskCreator;

    public TestTask getTestTask() {
        return testTask;
    }

    public void setTestTask(TestTask testTask) {
        this.testTask = testTask;
    }

    public List<TestTaskDetail> getTestTaskDetails() {
        return testTaskDetails;
    }

    public void setTestTaskDetails(List<TestTaskDetail> testTaskDetails) {
        this.testTaskDetails = testTaskDetails;
    }

    public String getTestDatasetName() {
        return testDatasetName;
    }

    public void setTestDatasetName(String testDatasetName) {
        this.testDatasetName = testDatasetName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getTestTaskCreator() {
        return testTaskCreator;
    }

    public void setTestTaskCreator(String testTaskCreator) {
        this.testTaskCreator = testTaskCreator;
    }

}
