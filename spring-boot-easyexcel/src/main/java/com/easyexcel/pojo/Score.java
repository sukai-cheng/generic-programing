package com.easyexcel.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "score")
public class Score {
    @TableField(value = "cour_id")
    private Integer courId;

    @TableField(value = "stu_id")
    private Integer stuId;

    @TableField(value = "sco_score")
    private String scoScore;
}