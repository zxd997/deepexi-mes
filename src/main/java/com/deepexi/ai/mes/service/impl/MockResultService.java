package com.deepexi.ai.mes.service.impl;

import com.deepexi.ai.mes.dao.IMockResultDao;
import com.deepexi.ai.mes.model.MockResult;
import com.deepexi.ai.mes.service.IMockResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MockResultService implements IMockResultService {

    @Autowired
    IMockResultDao mockResultDao;

    public Double[][] createRoc(){
        Sort sort = new Sort(Sort.Direction.DESC, "possibility");
        // todo 可以根据modelId, weightId，taskId等去查
        List<MockResult> mockResultList = mockResultDao.findAll(sort);
        String posLabel = mockResultList.get(0).getLabel();       //默认第一个样本的标签为正样本
        Integer posTotal = mockResultDao.countByLabel(posLabel);   //测试样本实际正标签数
        Integer negTotal = mockResultList.size() - posTotal;      //测试样本实际负标签数

        Double[][] roc = new Double[mockResultList.size()][2];
        for(int i = 0; i < mockResultList.size(); i++) {
            Double thresHold = mockResultList.get(i).getPossibility();
            Integer prePosTotal = 0;    //TP
            Integer preNegTotal = 0;    //FP
            for (MockResult mockResult : mockResultList) {
                if (mockResult.getPossibility() >= thresHold) {
                    if (mockResult.getLabel().equals(posLabel))
                        prePosTotal++;
                    else
                        preNegTotal++;
                }
            }
            roc[i][0] = (double)preNegTotal / negTotal;   //FPR
            roc[i][1] = (double)prePosTotal / posTotal;   //TPR
        }
        return roc;
    }

}