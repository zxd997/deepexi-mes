package com.deepexi.ai.mes.service;

import com.deepexi.ai.mes.dto.CrossoverChartDto;
import com.deepexi.ai.mes.dto.FrequencyHistogramDetailsDto;
import com.deepexi.ai.mes.model.TestResult;

import java.util.List;

public interface ITestResultService {
    /**
     * 存测试结果到数据库
     * @param testResultList
     */
    void save(List<TestResult> testResultList);

    FrequencyHistogramDetailsDto getFrequencyHistogram(String weightId);

    /**
     * 根据weightId取数据画出交叉表
     * @param weightId
     */
    CrossoverChartDto getCrossoverChart(String weightId);
    /**
     * 根据外部接口传来的数据存到数据库
     * @param testResults
     * @return
     */
    void saveMockAndMetaResultList(String testResults);
}
