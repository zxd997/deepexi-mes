package com.deepexi.ai.mes.model;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.Date;
import java.util.UUID;

/**
 * @author lyon
 * @date   2018/12/5 10:50
 * @detail 测试任务实体类
 */
@Document(collection = "test_task_detail")
public class TestTaskDetail {
    //weightTestStatus 0：异常、1：正在进行、2：已完成
    public TestTaskDetail(){
        this.id = UUID.randomUUID().toString();
        this.beginDate = new Date();
        this.weightTestStatus = 1;
    }
    /**
     * 权重测试id
     */
    @Id
    private String id;
    /**
     * 测试任务id
     */
    private String testTaskId;
    /**
     * 权重ID
     */
    private String weightId;
    /**
     * 权重名称
     */
    private String weightName;
    /**
     * 权重测试状态
     */
    private Integer weightTestStatus;
    /**
     * 权重测试开始时间
     */
    private Date beginDate;
    /**
     * 权重测试结束时间
     */
    private Date endDate;
    /**
     * 权重测试准确率
     */
    private String accuracy;
    /**
     * 权重AUC
     */
    private Double auc;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTestTaskId() {
        return testTaskId;
    }

    public void setTestTaskId(String testTaskId) {
        this.testTaskId = testTaskId;
    }

    public String getWeightId() {
        return weightId;
    }

    public void setWeightId(String weightId) {
        this.weightId = weightId;
    }

    public String getWeightName() {
        return weightName;
    }

    public void setWeightName(String weightName) {
        this.weightName = weightName;
    }

    public Integer getWeightTestStatus() {
        return weightTestStatus;
    }

    public void setWeightTestStatus(Integer weightTestStatus) {
        this.weightTestStatus = weightTestStatus;
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

    public String getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(String accuracy) {
        this.accuracy = accuracy;
    }

    public Double getAuc() {
        return auc;
    }

    public void setAuc(Double auc) {
        this.auc = auc;
    }
}
