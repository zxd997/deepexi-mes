package com.deepexi.ai.mes.dto;

import com.deepexi.ai.mes.model.DataSet;
import com.deepexi.ai.mes.model.Image;
import com.deepexi.ai.mes.model.TestTask;
import io.swagger.models.auth.In;

import java.util.List;

/**
 * @author lyon
 * @date   2018/12/5 11:44
 * @detail 测试任务创建页面Dto实体
 */
public class TestTaskPostDto {
    /**
     * 测试任务实体
     */
    private TestTask testTask;
    /**
     * 测试任务权重选择
     * 0表示自动筛选20个，1表示筛选全部
     */
    private Integer weightChoice;
    /**
     * 模型名称
     */
    private String modelName;
    /**
     * 测试集名称
     */
    private String testDatasetName;

    public TestTask getTestTask() {
        return testTask;
    }

    public void setTestTask(TestTask testTask) {
        this.testTask = testTask;
    }

    public Integer getWeightChoice() {
        return weightChoice;
    }

    public void setWeightChoice(Integer weightChoice) {
        this.weightChoice = weightChoice;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getTestDatasetName() {
        return testDatasetName;
    }

    public void setTestDatasetName(String testDatasetName) {
        this.testDatasetName = testDatasetName;
    }

}
