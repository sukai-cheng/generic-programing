package com.seckill.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public enum ResBeanEnum {

    // 通用
    SUCCESS(200, "SUCCESS"),
    ERROR(500, "服务端异常"),

    // 登陆
    LOGIN_ERROR(500210, "用户名或密码错误"),
    MOBILE_ERROR(500211, "手机格式不正确"),
    BIND_ERROR(500212, "参数校验异常"),
    SESSION_ERROR(500215, "用户SESSION不存在"),
    //秒杀模块
    EMPTY_STOCK(500500, "库存不足"),
    ACCESS_LIMIT_REACHED(500504, "访问过于频繁，请稍后重试"),
    REPEATE(500501, "该商品每人限购一个");

    private final Integer code;
    private final String message;
}
