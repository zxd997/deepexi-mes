package com.deepexi.ai.mes.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.deepexi.ai.mes.dao.IMockResultDao;
import com.deepexi.ai.mes.dao.ITestResultDao;
import com.deepexi.ai.mes.dto.CrossoverChartDto;
import com.deepexi.ai.mes.dto.FrequencyHistogramDetailsDto;
import com.deepexi.ai.mes.dto.FrequencyHistogramDto;
import com.deepexi.ai.mes.enums.TestLabelResultEnums;
import com.deepexi.ai.mes.model.MetaResult;
import com.deepexi.ai.mes.model.MockResult;
import com.deepexi.ai.mes.model.TestResult;
import com.deepexi.ai.mes.service.ITestResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author Zxd
 * @description TestResultService
 **/
@Service
public class TestResultService implements ITestResultService {
    final double begin= 0;
    final double interval = 0.05;
    final double total = (1-begin)/interval;
    @Autowired
    ITestResultDao testResultDao;
    @Autowired
    IMockResultDao mockResultDao;
    @Override
    public void save(List<TestResult> testResultList) {
        testResultDao.saveAll(testResultList);
    }

    @Override
    public FrequencyHistogramDetailsDto getFrequencyHistogram(String weightId) {
        FrequencyHistogramDetailsDto frequencyHistogramDetailsDto = new FrequencyHistogramDetailsDto();
        List<FrequencyHistogramDto> fhdList = new ArrayList<>();
        List<TestResult> testResultList = testResultDao.findByWeightId(weightId);
        //个案数
        int num = testResultList.size();
        double possibilityCount = 0;
        //方差
        double variance = 0;
        for (TestResult testResult:testResultList){
            possibilityCount += testResult.getPossibility();
        }
        //平均值
        double avg = (double) Math.round((possibilityCount/num) * 100000000) / 100000000;
        for (TestResult testResult:testResultList){
            variance += (testResult.getPossibility()-avg)*(testResult.getPossibility()-avg);
        }
        //标准差
        double standardDeviation = (double) Math.round(Math.sqrt(variance / num) * 100000000) / 100000000;
        for (int i=0;i<total;i++){
            double xLeft = (double) Math.round((begin+i*interval) * 100) / 100;
            double xRight = (double) Math.round((begin+(i+1)*interval) * 100) / 100;
            int frequency = testResultDao.findByWeightIdAndPossibilityBetween(xLeft, xRight, weightId).size();
            FrequencyHistogramDto frequencyHistogramDto = new FrequencyHistogramDto(xLeft,xRight,frequency);
            fhdList.add(frequencyHistogramDto);
        }
        frequencyHistogramDetailsDto.setFrequencyHistogramDtoList(fhdList);
        frequencyHistogramDetailsDto.setNum(num);
        frequencyHistogramDetailsDto.setAvg(avg);
        frequencyHistogramDetailsDto.setStandardDeviation(standardDeviation);
        return frequencyHistogramDetailsDto;
    }

    @Override
    public CrossoverChartDto getCrossoverChart(String weightId) {
        CrossoverChartDto chartDto = new CrossoverChartDto();
        List<TestResult> testResults = testResultDao.findAllByWeightId(weightId);
        List<Map<String,Integer>> predList = new ArrayList<>();
        List<Map<String,Integer>> labelList = new ArrayList<>();
        //获取所有标记label
        Set<String> labelSet = new HashSet<>();
        for(int i=0; i<testResults.size(); i++){
            labelSet.add(testResults.get(i).getLabels());
        }
        List<String> labels = new ArrayList<>();
        List<List<Integer>> counts = new ArrayList<>();
        //统计各个label出现的次数
        for(String labelName : labelSet){
            Integer predCount = testResultDao.countDistinctByWeightIdAndPred(weightId,labelName);
            Integer labelCount = testResultDao.countDistinctByWeightIdAndLabels(weightId,labelName);
            predList.add(new HashMap<String,Integer>(){{put(labelName,predCount);}});
            labelList.add(new HashMap<String,Integer>(){{put(labelName,labelCount);}});
            labels.add(labelName);
        }
        for(int j=0; j<labels.size(); j++){
            String labelName = labels.get(j);
            List<Integer> list = new ArrayList<>();
            for(int k=0; k<labels.size(); k++){
                String predName = labels.get(k);
                Integer count = testResultDao.countDistinctByLabelsAndPred(labelName,predName);
                list.add(count);
            }
            counts.add(list);
        }
        chartDto.setLabels(labels);
        chartDto.setCounts(counts);
        chartDto.setPredList(predList);
        chartDto.setLabelList(labelList);
        chartDto.setTotalCount(testResults.size());
        return chartDto;
    }
    @Override
    public void saveMockAndMetaResultList(String testResults){
        List<MockResult> mockResultList = new ArrayList<>();
        List<MetaResult> metaResultList = new ArrayList<>();
        JSONArray jsonArray = JSON.parseArray(testResults);
        for (int i=0;i<jsonArray.size();i++){
            MetaResult metaResult = new MetaResult();
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            //filename
            String filename = jsonObject.getString("filename");
            //true_or_false
            //Integer true_or_false = jsonObject.getInteger("true_or_false");
            //labels
            String labels = jsonObject.getJSONArray("labels").getString(0);
            metaResult.setFilename(filename);
            metaResult.setLabel(labels);
            metaResultList.add(metaResult);
            //results
            JSONArray results = jsonObject.getJSONArray("results");
            for (int j=0;j<results.size();j++){
                MockResult mockResult = new MockResult();
                JSONArray jsonArray1 = results.getJSONArray(j);
                String label2 = jsonArray1.getJSONArray(0).getString(0);
                double possibility = jsonArray1.getDouble(1);
                mockResult.setFilename(filename);
                mockResult.setLabel(label2);
                mockResult.setPossibility(possibility);
                mockResult.setFlag((label2.equals(labels)) ? TestLabelResultEnums.TRUE:TestLabelResultEnums.FALSE);
                mockResult.setMetaResultId(metaResult.getId());
                mockResultList.add(mockResult);
            }
        }
        mockResultDao.saveAll(mockResultList);
//        metaResultDao.saveAll(metaResultList);
    }
}
