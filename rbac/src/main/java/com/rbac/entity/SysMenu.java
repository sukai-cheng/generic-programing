package com.rbac.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
    * 权限表
    */
@Data
@TableName(value = "sys_menu")
public class SysMenu {
    /**
     * 菜单ID
     */
    @TableId(value = "menu_id", type = IdType.AUTO)
    private Long menuId;

    /**
     * 菜单名称
     */
    @TableField(value = "menu_name")
    private String menuName;

    /**
     * 路由地址
     */
    @TableField(value = "\"path\"")
    private String path;

    /**
     * 组件路径
     */
    @TableField(value = "component")
    private String component;

    /**
     * 菜单是否可见（0显示 1隐藏）
     */
    @TableField(value = "visible")
    private String visible;

    /**
     * 菜单状态（0正常 1停用）
     */
    @TableField(value = "\"status\"")
    private String status;

    /**
     * 权限标识
     */
    @TableField(value = "perms")
    private String perms;

    /**
     * 菜单图标
     */
    @TableField(value = "icon")
    private String icon;

    /**
     * 删除标志（0存在 1删除）
     */
    @TableField(value = "del_flag")
    private String delFlag;

    /**
     * 备注信息
     */
    @TableField(value = "remark")
    private String remark;

    public static final String COL_MENU_ID = "menu_id";

    public static final String COL_MENU_NAME = "menu_name";

    public static final String COL_PATH = "path";

    public static final String COL_COMPONENT = "component";

    public static final String COL_VISIBLE = "visible";

    public static final String COL_STATUS = "status";

    public static final String COL_PERMS = "perms";

    public static final String COL_ICON = "icon";

    public static final String COL_DEL_FLAG = "del_flag";

    public static final String COL_REMARK = "remark";
}