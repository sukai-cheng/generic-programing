package com.easyexcel.pojo;

import com.alibaba.excel.annotation.ExcelProperty;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

public class ActResultLogVO implements Serializable {
    @Serial
    private static final long serialVersionUID = 4907411214493918697L;

    @ExcelProperty({"行政区名称", "行政区名称"})
    private String onlineseqid;

    @ExcelProperty({"疫木处置总体情况","疫木处置总重量（公斤）"})
    private String businessid;

    @ExcelProperty({"疫木处置总体情况","疫木处置总重量（公斤）"})
    private String becifno;

    @ExcelProperty({"疫木处置总体情况","疫木处置总重量（公斤）"})
    private String ivisresult;

    @ExcelProperty({"疫木处置总体情况","疫木处置总重量（公斤）"})
    private String createdby;

    @ExcelProperty(value = "createddate",index = 5)
    private LocalDate createddate;

    @ExcelProperty(value = "updateby",index = 6)
    private String updateby;

    @ExcelProperty(value = "updateddate",index = 7)
    private LocalDate updateddate;

    @ExcelProperty(value = "risklevel",index = 8)
    private String risklevel;
}
