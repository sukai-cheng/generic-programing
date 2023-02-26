package com.jpa.utils;


import com.jpa.constants.HttpStatus;

import java.util.HashMap;

/**
 * 操作消息提醒
 *
 * @author ruoyi
 */
public class AjaxResult extends HashMap<String, Object> {

    private static final long serialVersionUID = 1L;

    /** 状态码 */
    public static final String CODE_TAG = "code";

    /** 返回内容 */
    public static final String MSG_TAG = "msg";

    /** 数据对象 */
    public static final String DATA_TAG = "data";

    public static final String MY_TAG = "rows";

    public static final String TOTAL_TAG = "total";

    /**
     * 初始化一个新创建的 AjaxResult 对象，使其表示一个空消息。
     */
    public AjaxResult() {

    }

    /**
     * 初始化一个新创建的 AjaxResult 对象
     *
     * @param code
     *            状态码
     * @param msg
     *            返回内容
     */
    public AjaxResult(final int code, final String msg) {

        super.put(CODE_TAG, code);
        super.put(MSG_TAG, msg);
    }

    public AjaxResult(final int code, final Object data) {

        super.put(CODE_TAG, code);
        if (StringUtils.isNotNull(data)) {
            super.put(DATA_TAG, data);
        }
    }

    /**
     * 初始化一个新创建的 AjaxResult 对象
     *
     * @Author: chengsukai
     * @create 2022/3/22 4:23 PM
     */
    public AjaxResult(final Object data) {

        super.put(CODE_TAG, HttpStatus.SUCCESS);
        super.put(MY_TAG, data);
        super.put(MSG_TAG, null);
    }

    /**
     * 初始化一个带数据和总数的AjaxResult 对象
     * 
     * @Author: zhangyu
     * @create 2022-03-23
     */
    public AjaxResult(final Object rows, final long total) {

        super.put(CODE_TAG, HttpStatus.SUCCESS);
        if (StringUtils.isNotNull(rows)) {
            super.put(MY_TAG, rows);
        }
        super.put(MSG_TAG, "操作成功");
        super.put(TOTAL_TAG, total);
    }

    public AjaxResult(final int code) {

        super.put(CODE_TAG, code);
    }

    /**
     * 初始化一个新创建的 AjaxResult 对象
     *
     * @param code
     *            状态码
     * @param msg
     *            返回内容
     * @param data
     *            数据对象
     */
    public AjaxResult(final int code, final String msg, final Object data) {

        super.put(CODE_TAG, code);
        super.put(MSG_TAG, msg);
        if (StringUtils.isNotNull(data)) {
            super.put(DATA_TAG, data);
        }
    }

    /**
     * 返回成功消息
     *
     * @return 成功消息
     */
    public static AjaxResult success() {

        return new AjaxResult(HttpStatus.SUCCESS);
    }

    /**
     * 返回成功消息
     *
     * @param msg
     *            返回内容
     * @return 成功消息
     */
    public static AjaxResult success(final String msg) {

        return AjaxResult.success(msg, null);
    }

    /**
     * 返回成功消息
     *
     * @param msg
     *            返回内容
     * @param data
     *            数据对象
     * @return 成功消息
     */
    public static AjaxResult success(final String msg, final Object data) {

        return new AjaxResult(HttpStatus.SUCCESS, msg, data);
    }

    public static AjaxResult success(final Object data) {

        return new AjaxResult(HttpStatus.SUCCESS, data);
    }

    public static AjaxResult success(final Object rows, final long total) {

        return new AjaxResult(rows, total);
    }

    /**
     * 返回错误消息
     *
     * @return 警告消息
     */
    public static AjaxResult error() {

        return AjaxResult.error("操作失败");
    }

    /**
     * 返回错误消息
     *
     * @param msg
     *            返回内容
     * @return 警告消息
     */
    public static AjaxResult error(final String msg) {

        return AjaxResult.error(msg, null);
    }

    /**
     * 返回错误消息
     *
     * @param msg
     *            返回内容
     * @param data
     *            数据对象
     * @return 警告消息
     */
    public static AjaxResult error(final String msg, final Object data) {

        return new AjaxResult(HttpStatus.ERROR, msg, data);
    }

    /**
     * 返回错误消息
     *
     * @param code
     *            状态码
     * @param msg
     *            返回内容
     * @return 警告消息
     */
    public static AjaxResult error(final int code, final String msg) {

        return new AjaxResult(code, msg, null);
    }
}
