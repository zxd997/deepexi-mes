package com.deepexi.ai.mes.controller;

import com.deepexi.ai.mes.dao.ITestDao;
import com.deepexi.ai.mes.model.Model;
import com.deepexi.ai.mes.model.Test;
import com.deepexi.ai.mes.model.Weight;
import com.deepexi.ai.mes.service.impl.ModelService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author central
 * @Date 2018/11/26 12:23
 */

@Api(value = "TestController", tags = {"测试接口"})
@RequestMapping("/test")
@RestController
public class TestController {

    @Autowired
    ITestDao testDao;
    @Autowired
    ModelService modelService;
    @PostMapping("/")
    public void test() {
        Test test = new Test();
        test.setUsername("ss");
        testDao.save(test);
    }

}
