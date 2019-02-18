package com.deepexi.ai.mes.service.impl;


import com.deepexi.ai.mes.dao.IModelDao;
import com.deepexi.ai.mes.dao.IWeightDao;
import com.deepexi.ai.mes.model.Model;
import com.deepexi.ai.mes.model.Weight;
import com.deepexi.ai.mes.service.IModelService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Collection;
import java.util.Optional;

/**@Author Zxd
 * 模型服务类
 */

@Service
public class ModelService implements IModelService {

    @Autowired
    IModelDao modelDao;

    @Autowired
    IWeightDao weightDao;

    public final String path ="C:\\Users\\zxd\\Desktop\\deep_model";
    //public final String path ="C:\\Users\\flowi\\Desktop\\deep_model";
    /**
     * 读取指定路径下的模型文件，存到数据库，并返回 Model
     * @return
     */
    @Override
    public Model importModel(String name){
        Model model = new Model();
        model.setName(name);
        model.setPath(new File(path).getAbsolutePath());
        Collection<File> fileList = FileUtils.listFiles(new File(path), null, false);
        for (File file : fileList){
            if (file.isFile()) {
                String fileName = file.getName();
                if (fileName.endsWith("json")){
                    model.setModelName(fileName);
                }
                if (fileName.endsWith("h5")){
                    Weight weight = new Weight();
                    weight.setModelId(model.getId());
                    weight.setWeightName(fileName);
                    weightDao.save(weight);
                }
            }
        }
        modelDao.save(model);
        return model;
    }

    /**
     * 分页获取模型列表
     * @param pageable
     * @return
     */
    @Override
    public Page<Model> findAllModel(Pageable pageable){

        Page<Model> modelPage = modelDao.findAll(pageable);
        return modelPage;
    }

    /**
     * 根据id 查Model
     * @param id
     * @return
     */
    @Override
    public Model findModelById(String id){
        Optional<Model> modelOptional = modelDao.findById(id);
        Model model = modelOptional.get();
        return model;
    }

    /**
     * 根据model ID 查权重
     * @param id
     * @return
     */
    @Override
    public Weight findWeightByModelId(String id){
        Weight weight = weightDao.findByModelId(id);
        return weight;
    }

//    @Test
//    public void fun11(){
//        ModelFileService modelFileService = new ModelFileService();
//        modelFileService.importModel();
//    }
}
