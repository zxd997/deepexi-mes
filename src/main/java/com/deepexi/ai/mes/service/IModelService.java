package com.deepexi.ai.mes.service;

import com.deepexi.ai.mes.model.Model;
import com.deepexi.ai.mes.model.Weight;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IModelService {
    /**
     * 读取指定路径下的模型文件，存到数据库，并返回 Model
     * @return
     */
    Model importModel(String modelName);

    /**
     * 分页获取模型列表
     * @param pageable
     * @return
     */
    Page<Model> findAllModel(Pageable pageable);

    Model findModelById(String id);

    Weight findWeightByModelId(String id);
}
