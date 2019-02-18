package com.deepexi.ai.mes.service;

import com.deepexi.ai.mes.model.TestDataSet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ITestDatasetService {

    /**
     * 创建新测试集
     */
    TestDataSet createTestDataset(TestDataSet testDataSet) throws Exception;
    /**
     * 删除数据集
     */
    void deleteTestDataset(String dataSetId);
    /**
     * 获取所有的测试集
     */
    List<TestDataSet> findAllTestDataset();
    /**
     * 分页获取所有的测试集，默认每页显示10条
     */
    Page<TestDataSet> findAllTestDatasetByPageQuery(Pageable pageable);
    /**
     * FIXME
     * @param pageable
     * @return
     */
    List<TestDataSet> findAllTestDataset(Pageable pageable);

}
