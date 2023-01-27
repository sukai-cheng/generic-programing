package com.rbac.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
    * 用户角色关联表
    */
@Data
@TableName(value = "sys_user_role")
public class SysUserRole {
    /**
     * 用户ID
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Long userId;

    /**
     * 角色ID
     */
    @TableId(value = "role_id", type = IdType.AUTO)
    private Long roleId;

    public static final String COL_USER_ID = "user_id";

    public static final String COL_ROLE_ID = "role_id";
}