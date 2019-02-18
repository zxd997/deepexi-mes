package com.deepexi.ai.mes.dao;

import com.deepexi.ai.mes.model.TestTaskDetail;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


/**
 * @author lyon
 * @date   2018/12/5 16:21
 * @detail 测试任务：权重测试详情(子任务)DAO接口
 */
public interface ITestTaskDetailDao extends MongoRepository<TestTaskDetail,String> {
    /**
     * 根据测试任务id查找子权重测试详情列表
     */
    List<TestTaskDetail> findTestTaskDetailsByTestTaskId(String testTaskId);
}
