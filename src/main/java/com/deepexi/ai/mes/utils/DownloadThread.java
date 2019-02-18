package com.deepexi.ai.mes.utils;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author Lyon
 * @date 2018/11/30 16:54
 * @description DownloadThread
 **/
public class DownloadThread implements Runnable{

    private String url;

    private String path;

    public DownloadThread(String url, String path){
        this.url = url;
        this.path = path;
    }

    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName() + "正在下载图片。。。");
        try {
            URL tgtUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection)tgtUrl.openConnection();
            DataInputStream in = new DataInputStream(connection.getInputStream());
            //此处也可用BufferedInputStream与BufferedOutputStream
            DataOutputStream out = new DataOutputStream(new FileOutputStream(path));
            byte[] buffer = new byte[4096];
            int count = 0;
            while ((count = in.read(buffer)) > 0) {
                out.write(buffer, 0, count);
            }
            out.close();
            in.close();
            connection.disconnect();
            System.out.println(Thread.currentThread().getName() + "下载完成。。。");
        } catch (Exception e) {
            System.out.println("\nsave image failed:"+url + path +"\n"+ e);
        }
    }
}
