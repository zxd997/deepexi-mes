package com.deepexi.ai.mes.service;


import com.deepexi.ai.mes.dto.ImageUrlDto;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author lyon
 * @date   2018/11/30 12:27
 * @detail
 */
public interface IImageService {
    /**
     * @param  list
     * @return
     * @detail 将列表中的图片，按lebel分类下载到不同文件夹
     */
    void sortDownloadImages(List<ImageUrlDto> list, HttpServletRequest request)throws Exception;

    void sortDownloadImages2(List<ImageUrlDto> list)throws Exception;
}
