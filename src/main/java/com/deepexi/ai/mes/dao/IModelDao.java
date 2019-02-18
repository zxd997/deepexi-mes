package com.deepexi.ai.mes.dao;

import com.deepexi.ai.mes.model.Model;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IModelDao extends MongoRepository<Model,String> {
}
