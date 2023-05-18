package com.easyexcel.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "student")
public class Student {
    @TableId(value = "stu_id", type = IdType.AUTO)
    private Integer stuId;

    @TableField(value = "stu_name")
    private String stuName;

    @TableField(value = "stu_password")
    private String stuPassword;

    @TableField(value = "stu_gender")
    private String stuGender;

    @TableField(value = "stu_address")
    private String stuAddress;
}