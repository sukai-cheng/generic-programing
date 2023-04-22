package com.easyexcel.pojo;

import com.alibaba.excel.annotation.ExcelProperty;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

public class ActResultLogVO implements Serializable {
    @Serial
    private static final long serialVersionUID = 4907411214493918697L;

    @ExcelProperty(value = "onlineseqid", index = 0)
    private String onlineseqid;

    @ExcelProperty(value = "businessid",index = 1)
    private String businessid;

    @ExcelProperty(value = "becifno",index = 2)
    private String becifno;

    @ExcelProperty(value = "ivisresult",index = 3)
    private String ivisresult;

    @ExcelProperty(value = "createdby",index = 4)
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
