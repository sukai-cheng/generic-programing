package com.easyexcel.po;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.easyexcel.convert.GenderConverter;
import lombok.Data;

/**
 * @author chengsukai
 */
@Data
@TableName(value = "t_user")
public class UserPO {
    @TableId(value = "id", type = IdType.AUTO)
    @ExcelIgnore
    private Integer id;

    @ExcelProperty(value = "姓名")
    private String username;

    @ExcelProperty(value = "性别")
    private Integer age;

    @ExcelProperty(value = "性别", converter = GenderConverter.class)
    private Integer gender;

}