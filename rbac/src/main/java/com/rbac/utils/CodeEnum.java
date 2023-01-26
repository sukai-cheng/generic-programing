package com.rbac.utils;

public enum CodeEnum {

    OK(200, "success"),
    ERROR(500, "failure"),
    ;

    private final int code;
    private final String msg;

    CodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
