package com.deepexi.ai.mes.utils;

import com.deepexi.ai.mes.service.impl.TestResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

/**
 * @author Lyon
 * @date 2018/12/5 22:22
 * @description WeightTestResultThread
 **/
public class WeightTestResultThread implements Runnable{

    @Autowired
    TestResultService testResultService;

    private String url;

    public WeightTestResultThread(String url){
        this.url = url;
    }

    @Override
    public void run(){
        try{
            System.out.println(Thread.currentThread().getName() + "WeightTestResultThread()线程正在执行。。。");
            RestTemplate template = new RestTemplate();
            String  resultString = template.getForObject(url, String.class);
            testResultService.saveMockAndMetaResultList(resultString);
            System.out.println(Thread.currentThread().getName() + "WeightTestResultThread()线程执行完成。。。");
        }catch (Exception e){
            System.out.println("WeightTestResultThread()线程异常："+e);
        }
    }
}
