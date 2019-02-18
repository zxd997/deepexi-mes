package com.deepexi.ai.mes.model;

import com.deepexi.ai.mes.enums.TestTaskStatusEnums;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author lyon
 * @date   2018/12/5 10:50
 * @detail 测试任务实体类
 */
@Document(collection = "test_task")
public class TestTask {
    public TestTask(){
        this.id = UUID.randomUUID().toString();
        this.createDate = new Date();
        this.beginDate = new Date();
        this.taskStatus = TestTaskStatusEnums.BEGIN;
        this.testTaskName = "测试任务" + new Date();
    }
    /**
     * 测试任务id
     */
    @Id
    private String id;
    /**
     * 测试任务名称
     */
    private String testTaskName;
    /**
     * 测试集ID
     */
    private String testDatasetId;
    /**
     * 模型ID
     */
    private String modelId;
    /**
     * 权重测试列表
     */
    private Integer weightChoice;
    /**
     * 权重测试列表
     */
    private List<Weight> weightList;
    /**
     * 测试任务状态
     */
    private Integer taskStatus;
    /**
     * 测试任务创建时间
     */
    private Date createDate;
    /**
     * 测试任务开始时间
     */
    private Date beginDate;
    /**
     * 测试任务结束时间
     */
    private Date endDate;
    /**
     * 模型名称
     */
    @Transient
    private String modelName;
    /**
     * 权重数量
     */
    @Transient
    private String weightCount;
    /**
     * 测试集名称
     */
    @Transient
    private String testDatasetName;
    /**
     * 测试任务创建者
     */
    @Transient
    private String creator;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTestTaskName() {
        return testTaskName;
    }

    public void setTestTaskName(String testTaskName) {
        this.testTaskName = testTaskName;
    }

    public String getTestDatasetId() {
        return testDatasetId;
    }

    public void setTestDatasetId(String testDatasetId) {
        this.testDatasetId = testDatasetId;
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public Integer getWeightChoice() {
        return weightChoice;
    }

    public void setWeightChoice(Integer weightChoice) {
        this.weightChoice = weightChoice;
    }

    public List<Weight> getWeightList() {
        return weightList;
    }

    public void setWeightList(List<Weight> weightList) {
        this.weightList = weightList;
    }

    public Integer getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(Integer taskStatus) {
        this.taskStatus = taskStatus;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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



}
