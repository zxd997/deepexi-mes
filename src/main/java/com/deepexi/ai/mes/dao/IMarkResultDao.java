package com.deepexi.ai.mes.dao;


import com.deepexi.ai.mes.model.MarkResult;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author lyon
 * @date   2018/11/29 10:58
 * @detail 标记结果DAO层
 */
public interface IMarkResultDao extends MongoRepository<MarkResult,String> {


    List<MarkResult> findMarkResultsBySeriesId(String seriesId);
}
