package com.utils.service;

import com.utils.common.R;
import com.utils.entity.File;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author 白也
 * @date 2022/12/21 2:35 下午
 * @title
 */
public interface FileService {
    /**
     * 上传文件
     * @param file 文件
     */
    List<File> uploader(MultipartFile file);

    /**
     * 查询
     */
    List<File> selectAll();

    /**
     * 删除文件
     * @param fileName 文件名
     */
    R delete(String fileName);

    /**
     * 下载文件
     * @param fileName 文件名
     */
    R download(HttpServletResponse response, String fileName);

}
