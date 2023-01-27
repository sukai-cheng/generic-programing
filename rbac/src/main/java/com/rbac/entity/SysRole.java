package com.rbac.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
    * 角色表
    */
@Data
@TableName(value = "sys_role")
public class SysRole {
    /**
     * 角色ID
     */
    @TableId(value = "role_id", type = IdType.AUTO)
    private Long roleId;

    /**
     * 角色名称
     */
    @TableField(value = "role_name")
    private String roleName;

    /**
     * 角色权限字符串
     */
    @TableField(value = "role_key")
    private String roleKey;

    /**
     * 角色状态（0正常 1停用
     */
    @TableField(value = "\"status\"")
    private String status;

    /**
     * 删除标志(0正常 1停用)
     */
    @TableField(value = "del_flag")
    private String delFlag;

    /**
     * 备注信息
     */
    @TableField(value = "remark")
    private String remark;

    public static final String COL_ROLE_ID = "role_id";

    public static final String COL_ROLE_NAME = "role_name";

    public static final String COL_ROLE_KEY = "role_key";

    public static final String COL_STATUS = "status";

    public static final String COL_DEL_FLAG = "del_flag";

    public static final String COL_REMARK = "remark";
}