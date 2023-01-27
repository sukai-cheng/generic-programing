package com.rbac.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
    * 角色表
    */
@Data
@TableName(value = "sys_role_menu")
public class SysRoleMenu {
    /**
     * 角色ID
     */
    @TableId(value = "role_id", type = IdType.AUTO)
    private Long roleId;

    /**
     * 菜单ID
     */
    @TableId(value = "menu_id", type = IdType.AUTO)
    private Long menuId;

    public static final String COL_ROLE_ID = "role_id";

    public static final String COL_MENU_ID = "menu_id";
}