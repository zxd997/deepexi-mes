package com.deepexi.ai.mes.service;



import com.deepexi.ai.mes.model.MarkResult;

import java.util.List;
/**
 * @author lyon
 * @date   2018/11/30 12:27
 * @detail
 */
public interface IMarkResultService {

    /**
     * 直接保存areaMarkResult
     * @param markResult
     */
    void saveMarkResult(MarkResult markResult);

    /**
     * 保存所有result
     * @param markResultList
     */
    void saveAll(List<MarkResult> markResultList);

}
