package com.easyexcel.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "course")
public class Course {
    @TableId(value = "cour_id", type = IdType.AUTO)
    private Integer courId;

    @TableField(value = "cour_name")
    private String courName;

    @TableField(value = "tea_id")
    private String teaId;

    @TableField(value = "cour_time")
    private String courTime;
}