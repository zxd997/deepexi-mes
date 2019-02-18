package com.deepexi.ai.mes.dao;

import com.deepexi.ai.mes.model.Weight;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface IWeightDao extends MongoRepository<Weight,String> {
    Weight findByModelId(String id);

    /**
     * 根据modelId筛选全部权重
     */
    List<Weight> findWeightsByModelId(String modelId);
}
