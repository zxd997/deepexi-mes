package com.deepexi.ai.mes.dao;

import com.deepexi.ai.mes.model.TestTask;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author lyon
 * @date   2018/12/5 11:21
 * @detail 测试任务DAO接口
 */
public interface ITestTaskDao extends MongoRepository<TestTask, String> {
    /**
     * 根据模型id查询所有测试任务
     */
    List<TestTask> findTestTasksByModelId(String modelId);
    /**
     * 根据模型id和测试集id查询测试任务
     */
    TestTask findByModelIdAndTestDatasetId(String modelId, String testDatasetId);

    List<TestTask> findByTaskStatus(Integer begin);
}
