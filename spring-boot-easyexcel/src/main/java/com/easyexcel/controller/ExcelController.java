package com.easyexcel.controller;

import com.alibaba.excel.EasyExcel;
import com.easyexcel.listener.EasyExcelGeneralDataJDBCListener;
import com.easyexcel.service.ActResultLogService;
import com.easyexcel.utils.EasyExcelUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * excel导入导出功能
 * @author chengsukai
 */
@Slf4j
@RestController
@RequestMapping("/excel")
public class ExcelController {
    @Resource
    private EasyExcelUtil easyExcelUtil;

    @Resource
    private ActResultLogService actResultLogService;

    @Value("${easyexcel.import.path}")
    private String filePath;

    /**
     * 导出excel
     * @param response
     */
    @GetMapping("/export")
    public void exportExcel(HttpServletResponse response) {
        easyExcelUtil.dataExport300w(response);
    }

    /**
     * 导入excel
     * @param file
     * @return
     */
    @PostMapping("/import")
    public String uploadFiles(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "文件为空";
        }
        String fileName = file.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        log.info("file name: " + fileName);
        log.info("文件后缀名:" + suffixName);
        String path = filePath + fileName;
        log.info(path);
        long startReadTime = System.currentTimeMillis();
        log.info("------开始读取Excel的Sheet时间(包括导入数据过程):" + startReadTime + " ms------");
        EasyExcel.read(path, new EasyExcelGeneralDataJDBCListener(actResultLogService)).doReadAll();        long endReadTime = System.currentTimeMillis();
        log.info("------结束读取Excel的Sheet时间(包括导入数据过程):" + endReadTime + " ms------");
        log.info("------导入总花费时长：{}", ((endReadTime - startReadTime) / 1000) + "s------");
        return "导出成功";
    }
}
