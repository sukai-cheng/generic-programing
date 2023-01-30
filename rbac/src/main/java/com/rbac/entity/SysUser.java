package com.rbac.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
    * 用户表
    */
@Data
@TableName(value = "sys_user")
public class SysUser {
    @TableId(value = "user_id", type = IdType.AUTO)
    private Long userId;

    /**
     * 用户名字
     */
    @TableField(value = "user_name")
    private String userName;

    /**
     * 用户昵称
     */
    @TableField(value = "nick_name")
    private String nickName;

    /**
     * 密码
     */
    @TableField(value = "\"password\"")
    private String password;

    /**
     * 账号状态(0正常 1停用)
     */
    @TableField(value = "\"status\"")
    private String status;

    /**
     * 邮箱
     */
    @TableField(value = "email")
    private String email;

    /**
     * 电话号码
     */
    @TableField(value = "phone_number")
    private String phoneNumber;

    /**
     * 性别
     */
    @TableField(value = "sex")
    private String sex;

    /**
     * 头像
     */
    @TableField(value = "avatar")
    private String avatar;

    /**
     * 用户类型(0管理员 1普通用户)
     */
    @TableField(value = "user_type")
    private String userType;

    /**
     * 删除标志(0未删除 1已删除)
     */
    @TableField(value = "del_flag")
    private String delFlag;

    /**
     * 备注信息
     */
    @TableField(value = "remark")
    private String remark;
}