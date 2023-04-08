package com.seckill.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
    * 用户表
    */
@Data
@TableName(value = "t_user")
public class TUser implements Serializable {
    @Serial
    private static final long serialVersionUID = -1042294226461325758L;
    /**
     * 用户ID,手机号码
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField(value = "nickname")
    private String nickname;

    /**
     * MD5(MD5(pass明文+固定salt)+salt)
     */
    @TableField(value = "`password`")
    private String password;

    @TableField(value = "salt")
    private String salt;

    /**
     * 头像
     */
    @TableField(value = "head")
    private String head;

    /**
     * 注册时间
     */
    @TableField(value = "register_date")
    private Date registerDate;

    /**
     * 最后一次登录事件
     */
    @TableField(value = "last_login_date")
    private Date lastLoginDate;

    /**
     * 登录次数
     */
    @TableField(value = "login_count")
    private Integer loginCount;
}