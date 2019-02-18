package com.deepexi.ai.mes.model;

import com.deepexi.ai.mes.dto.LabelCountDto;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author Lyon
 * @date 2018/11/30 18:26
 * @description TestDataSet
 **/
@Document(collection = "test_dataset")
public class TestDataSet {
    public TestDataSet(){
        this.id = UUID.randomUUID().toString();
        this.createAt = new Date();
    }
    /**
     * 测试集id
     */
    @Id
    private String id;
    /**
     * 测试任务Id
     */
    private String seriesId;
    /**
     * 测试集名称
     */
    private String testDatasetName;
    /**
     * 数据集id列表
     */
    private List<String> dataSetIdList;
    /**
     * 标记类型
     */
    private Integer markType;
    /**
     * 包含图片总数
     */
    private Integer imageCount;
    /**
     * 各个标记类型所包含的图片数
     */
    private List<LabelCountDto> labelInfoList;
    /**
     * 测试集创建时间
     */
    private Date createAt;
    /**
     * 测试集描述(保留字段)
     */
    private String description;
    /**
     * 测试集创建者(保留字段)
     */
    private String creator;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(String seriesId) {
        this.seriesId = seriesId;
    }

    public String getTestDatasetName() {
        return testDatasetName;
    }

    public void setTestDatasetName(String testDatasetName) {
        this.testDatasetName = testDatasetName;
    }

    public List<String> getDataSetIdList() {
        return dataSetIdList;
    }

    public void setDataSetIdList(List<String> dataSetIdList) {
        this.dataSetIdList = dataSetIdList;
    }

    public Integer getMarkType() {
        return markType;
    }

    public void setMarkType(Integer markType) {
        this.markType = markType;
    }

    public Integer getImageCount() {
        return imageCount;
    }

    public void setImageCount(Integer imageCount) {
        this.imageCount = imageCount;
    }

    public List<LabelCountDto> getLabelInfoList() {
        return labelInfoList;
    }

    public void setLabelInfoList(List<LabelCountDto> labelInfoList) {
        this.labelInfoList = labelInfoList;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }



}
