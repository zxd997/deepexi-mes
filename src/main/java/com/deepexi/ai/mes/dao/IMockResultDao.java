package com.deepexi.ai.mes.dao;

import com.deepexi.ai.mes.model.MockResult;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 模拟roc操作dao层
 * @author lxh
 * @date 2018年12月4日18点21分
 */
public interface IMockResultDao extends MongoRepository<MockResult,String> {

    /**
     * 查询该标签下的记录数
     * @param label
     * @return
     */
    int countByLabel(String label);
}
