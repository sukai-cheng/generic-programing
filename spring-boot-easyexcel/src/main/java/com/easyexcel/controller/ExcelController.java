package com.easyexcel.controller;

import com.easyexcel.utils.EasyExcelUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/excel")
public class ExcelController {
    @Resource
    private EasyExcelUtil easyExcelUtil;

    @GetMapping("/export")
    public void exportExcel(HttpServletResponse response) {
        easyExcelUtil.dataExport300w(response);
    }
}
