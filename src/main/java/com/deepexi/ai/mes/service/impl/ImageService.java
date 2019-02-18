package com.deepexi.ai.mes.service.impl;


import com.deepexi.ai.mes.dto.ImageUrlDto;
import com.deepexi.ai.mes.service.IImageService;
import com.deepexi.ai.mes.utils.DownloadThread;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


/**
 * @author lyon
 * @date   2018/11/30 11:18
 * @detail IImageService实现类
 */
@Service
public class ImageService implements IImageService {

    private final String FILEPATH = "C:/download/";

    @Override
    public void sortDownloadImages(List<ImageUrlDto> list, HttpServletRequest request)throws Exception {
        //服务器环境下：String FILEPATH = request.getSession().getServletContext().getRealPath("/");
        //构造HashSet存图片label
        Set<String> labelSet = new HashSet<>();
        for(int i=0; i<list.size(); i++){
            labelSet.add(list.get(i).getLabel());
        }
        //根据lebel创建对应文件夹
        Iterator it = labelSet.iterator();
        while(it.hasNext()){
            try{
                String labelName = (String)it.next();
                File file=new File(FILEPATH+labelName);
                if(!file.exists()){
                    file.mkdirs();
                }
            } catch (Exception f){}
        }
        //创建等待队列
        BlockingQueue<Runnable> bqueue = new ArrayBlockingQueue<Runnable>(10000);
        //创建线程池，池中核心线程数为3，允许的最大线程数10
        ThreadPoolExecutor pool = new ThreadPoolExecutor(3,10,50, TimeUnit.MILLISECONDS,bqueue);
        //逐个下载图片
        for(int i=0; i<list.size(); i++){
            ImageUrlDto image = list.get(i);
            String url = image.getImageUrl();
            String path = FILEPATH + image.getLabel()+"/" +image.getFilename();
            Runnable t = new DownloadThread(url,path);
            pool.execute(t);
            //单线程下载工具类：DownloadUtil.downloadImage(url,path);
        }
        pool.shutdown();
    }

    @Override
    public void sortDownloadImages2(List<ImageUrlDto> list)throws Exception {
        //构造HashSet存图片label
        Set<String> labelSet = new HashSet<>();
        for(int i=0; i<list.size(); i++){
            labelSet.add(list.get(i).getLabel());
        }
        //根据lebel创建对应文件夹
        Iterator it = labelSet.iterator();
        while(it.hasNext()){
            try{
                String labelName = (String)it.next();
                File file=new File(FILEPATH+labelName);
                if(!file.exists()){
                    file.mkdirs();
                }
            } catch (Exception f){}
        }
        //创建等待队列
        BlockingQueue<Runnable> bqueue = new ArrayBlockingQueue<Runnable>(10000);
        //创建线程池，池中核心线程数为3，允许的最大线程数10
        ThreadPoolExecutor pool = new ThreadPoolExecutor(3,10,50, TimeUnit.MILLISECONDS,bqueue);
        //逐个下载图片
        for(int i=0; i<list.size(); i++){
            ImageUrlDto image = list.get(i);
            String url = image.getImageUrl();
            String path = FILEPATH + image.getLabel()+"/" +image.getFilename();
            Runnable t = new DownloadThread(url,path);
            pool.execute(t);
            //单线程下载工具类：DownloadUtil.downloadImage(url,path);
        }
        pool.shutdown();
    }
}


