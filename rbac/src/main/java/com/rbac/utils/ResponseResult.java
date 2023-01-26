package com.rbac.utils;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResponseResult<T> implements Serializable {
    /**
     * 状态码
     */
    private Integer code;

    /**
     * 错误消息
     */
    private String msg;

    /**
     * 数据
     */
    private T data;

    /**
     * 无参构造
     */
    public ResponseResult() {
        this.code = CodeEnum.OK.getCode();
        this.msg = CodeEnum.OK.getMsg();
    }

    /**
     * 有参构造
     */
    public ResponseResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 有参构造
     */
    public ResponseResult(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
