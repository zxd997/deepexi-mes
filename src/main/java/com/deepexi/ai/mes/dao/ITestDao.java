package com.deepexi.ai.mes.dao;

import com.deepexi.ai.mes.model.Test;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @Author central
 * @Date 2018/11/26 12:23
 */

public interface ITestDao extends MongoRepository<Test,String> {
}
