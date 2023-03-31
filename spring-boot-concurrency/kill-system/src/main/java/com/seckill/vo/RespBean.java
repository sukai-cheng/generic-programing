package com.seckill.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RespBean {

    private long code;
    private String message;
    private Object obj;

    public static RespBean success() {
        return new RespBean(ResBeanEnum.SUCCESS.getCode(), ResBeanEnum.SUCCESS.getMessage(), null);
    }

    public static RespBean success(Object obj) {
        return new RespBean(ResBeanEnum.SUCCESS.getCode(), ResBeanEnum.SUCCESS.getMessage(), obj);
    }

    public static RespBean error(ResBeanEnum resBeanEnum) {
        return new RespBean(resBeanEnum.getCode(), resBeanEnum.getMessage(), null);
    }

    public static RespBean error(ResBeanEnum resBeanEnum, Object obj) {
        return new RespBean(resBeanEnum.getCode(), resBeanEnum.getMessage(), obj);
    }

}




















