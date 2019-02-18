package com.deepexi.ai.mes.service.impl;


import com.deepexi.ai.mes.dao.IMarkResultDao;
import com.deepexi.ai.mes.model.MarkResult;
import com.deepexi.ai.mes.service.IMarkResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author lyon
 * @date   2018/11/29 10:55
 * @detail 标记结果Servie层
 */
@Service
public class MarkResultService implements IMarkResultService {

    @Autowired
    IMarkResultDao markResultDao;

    /**
     * 保存单条标记结果
     *
     * @param markResult      标记结果实体bean
     * @return void
     */
    @Override
    public void saveMarkResult(MarkResult markResult) {
        markResultDao.save(markResult);
    }

    /**
     * 保存多条标记结果
     *
     * @param markResultList  标记结果实体bean列表
     * @return void
     */
    @Override
    public void saveAll(List<MarkResult> markResultList) {
        markResultDao.saveAll(markResultList);
    }

}
