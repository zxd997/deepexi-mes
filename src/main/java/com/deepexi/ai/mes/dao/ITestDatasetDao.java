package com.deepexi.ai.mes.dao;

import com.deepexi.ai.mes.model.TestDataSet;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author lyon
 * @date   2018/11/27 15:41
 */
public interface ITestDatasetDao extends MongoRepository<TestDataSet, String> {


}
