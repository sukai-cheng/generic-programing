package com.seckill.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public enum ResBeanEnum {
    SUCCESS(200,"SUCCESS"),
    ERROR(500,"服务端异常");

    private final Integer code;
    private final String message;
}
