package com.easyexcel.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;

/**
 * @author chengsukai
 */
@Data
@TableName(value = "act_result_log")
public class ActResultLogDO {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(value = "onlineseqid")
    private String onlineseqid;

    @TableField(value = "businessid")
    private String businessid;

    @TableField(value = "becifno")
    private String becifno;

    @TableField(value = "ivisresult")
    private String ivisresult;

    @TableField(value = "createdby")
    private String createdby;

    @TableField(value = "createddate")
    private Date createddate;

    @TableField(value = "updateby")
    private String updateby;

    @TableField(value = "updateddate")
    private Date updateddate;

    @TableField(value = "risklevel")
    private String risklevel;

    @TableField(value = "is_deleted")
    private Byte isDeleted;
}