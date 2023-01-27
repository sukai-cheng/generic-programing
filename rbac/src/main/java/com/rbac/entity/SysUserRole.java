package com.rbac.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.github.jeffreyning.mybatisplus.anno.MppMultiId;
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
    @MppMultiId
    @TableField(value = "user_id")
    private Long userId;

    /**
     * 角色ID
     */
    @MppMultiId
    @TableField(value = "role_id")
    private Long roleId;

    public static final String COL_USER_ID = "user_id";

    public static final String COL_ROLE_ID = "role_id";
}