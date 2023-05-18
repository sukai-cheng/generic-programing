package com.easyexcel.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author chengsukai
 */
@Data
@TableName(value = "job_list")
public class JobList {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 序号
     */
    @TableField(value = "order_num")
    private Integer orderNum;

    /**
     * 主管部门（区县、开发区)
     */
    @TableField(value = "main_dept")
    private String mainDept;

    /**
     * 事业单位名称
     */
    @TableField(value = "institution_name")
    private String institutionName;

    /**
     * 单位性质/经费形式
     */
    @TableField(value = "unit_nature")
    private String unitNature;

    /**
     * 岗位类别
     */
    @TableField(value = "position_category")
    private String positionCategory;

    /**
     * 岗位简称
     */
    @TableField(value = "position_name")
    private String positionName;

    /**
     * 岗位代码
     */
    @TableField(value = "position_code")
    private String positionCode;

    /**
     * 招聘人数
     */
    @TableField(value = "recruiters_num")
    private String recruitersNum;

    /**
     * 招聘岗位所需资格条件专业名称
     */
    @TableField(value = "needMajor_name")
    private String needmajorName;

    /**
     * 招聘岗位所需资格条件学历
     */
    @TableField(value = "need_record")
    private String needRecord;

    /**
     * 招聘岗位所需资格条件学位
     */
    @TableField(value = "need_degree")
    private String needDegree;

    /**
     * 招聘岗位所需资格条件其他条件
     */
    @TableField(value = "need_other_condition")
    private String needOtherCondition;

    /**
     * 笔试类别
     */
    @TableField(value = "written_type")
    private String writtenType;

    /**
     * 备注
     */
    @TableField(value = "mark")
    private String mark;
}