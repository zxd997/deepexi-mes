package com.deepexi.ai.mes.dao;

import com.deepexi.ai.mes.model.TestResult;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ITestResultDao extends MongoRepository<TestResult,String> {
    @Query("{'possibility':{$gt:?0,$lt:?1},'weightId':?2}")
    List<TestResult> findByWeightIdAndPossibilityBetween(double from, double to, String weightId) ;

    /**
     * 根据权重id查询所有测试结果
     * @param weightId
     * @return
     */
    @Query(fields="{'_id':1,'labels':1,'field':1}")
    List<TestResult> findAllByWeightId(String weightId);
    /**
     * 根据权重id和label，查询该label分类图片出现的次数
     * @param weightId
     * @return
     */
    Integer countDistinctByWeightIdAndLabels(String weightId, String labels);
    /**
     * 根据权重id和pred，查询机器判断过程中该lebal分类图片出现的次数
     * @param weightId
     * @return
     */
    Integer countDistinctByWeightIdAndPred(String weightId, String pred);
    /**
     * 根据权重label和pred，查询机器判断过程中特定组合出现的次数
     * @param labels,pred
     * @return
     */
    Integer countDistinctByLabelsAndPred(String labels, String pred);

    List<TestResult> findByWeightId(String weightId);
}
