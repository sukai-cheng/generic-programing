package com.jpa.constants;

import io.jsonwebtoken.Claims;

import java.math.BigDecimal;

/**
 * 通用常量信息
 *
 * @author ruoyi
 */
public class Constants {

    /**
     * UTF-8 字符集
     */
    public static final String UTF8 = "UTF-8";

    /**
     * GBK 字符集
     */
    public static final String GBK = "GBK";

    /**
     * http请求
     */
    public static final String HTTP = "http://";

    /**
     * https请求
     */
    public static final String HTTPS = "https://";

    /**
     * 通用成功标识
     */
    public static final String SUCCESS = "0";

    /**
     * 通用失败标识
     */
    public static final String FAIL = "1";

    /**
     * 登录成功
     */
    public static final String LOGIN_SUCCESS = "Success";

    /**
     * 注销
     */
    public static final String LOGOUT = "Logout";

    /**
     * 注册
     */
    public static final String REGISTER = "Register";

    /**
     * 登录失败
     */
    public static final String LOGIN_FAIL = "Error";

    /**
     * 验证码 redis key
     */
    public static final String CAPTCHA_CODE_KEY = "captcha_codes:";

    /**
     * 登录用户 redis key
     */
    public static final String LOGIN_TOKEN_KEY = "login_tokens:";

    /*
     * its当前登录用户
     */
    public static final String ITS_LOGIN_USER_HEADER = "ItsLoginUser";

    /**
     * 防重提交 redis key
     */
    public static final String REPEAT_SUBMIT_KEY = "repeat_submit:";

    /**
     * 限流 redis key
     */
    public static final String RATE_LIMIT_KEY = "rate_limit:";

    /**
     * 验证码有效期（分钟）
     */
    public static final Integer CAPTCHA_EXPIRATION = 2;

    /**
     * 令牌
     */
    public static final String TOKEN = "token";

    /**
     * 令牌前缀
     */
    public static final String TOKEN_PREFIX = "Bearer ";

    /**
     * 令牌前缀
     */
    public static final String LOGIN_USER_KEY = "login_user_key";

    /**
     * 用户ID
     */
    public static final String JWT_USERID = "userid";

    /**
     * 用户名称
     */
    public static final String JWT_USERNAME = Claims.SUBJECT;

    /**
     * 用户头像
     */
    public static final String JWT_AVATAR = "avatar";

    /**
     * 创建时间
     */
    public static final String JWT_CREATED = "created";

    /**
     * 用户权限
     */
    public static final String JWT_AUTHORITIES = "authorities";

    /**
     * 参数管理 cache key
     */
    public static final String SYS_CONFIG_KEY = "sys_config:";

    /**
     * 字典管理 cache key
     */
    public static final String SYS_DICT_KEY = "sys_dict:";

    /**
     * 资源映射路径 前缀
     */
    public static final String RESOURCE_PREFIX = "/profile";

    /**
     * RMI 远程方法调用
     */
    public static final String LOOKUP_RMI = "rmi://";

    /**
     * LDAP 远程方法调用
     */
    public static final String LOOKUP_LDAP = "ldap://";

    /**
     * 超级管理员权限
     */
    public static final String SUPER_ADMIN = "*:*:*";

    /**
     * 优惠类型 - Profile
     */
    public static final String PROFILE = "P";

    /**
     * 没有使用任何一种优惠方式
     */
    public static final String PROFILEISNONE = "N";

    /**
     * 优惠类型是Coupon
     */
    public static final String COUPON = "C";

    /**
     * 优惠卷的正常状态
     */
    public static final Integer COUPONNORMALENABLE = 0;

    /**
     * 优惠票种为空
     */
    public static final Integer PROFILEISNULL = 1;

    /**
     * 优惠卷为空
     */
    public static final Integer COUPONISNULL = 1;

    /**
     * 保险费用
     */
    public static final BigDecimal INSURANCE = new BigDecimal("5");

    //驾照
    public static final String CNIC = "0";

    //护照
    public static final String PASSPORT = "1";

    /**
     * 儿童
     */
    public static final Integer CHILD = 1;

    /**
     * 成人
     */
    public static final Integer ADULT = 0;

    /**
     * 最高的折扣是100%
     */
    public static final Double HIGHESTDISCOUNTDEGREE = 100d;

    //-------------------------its-------------------------
    /**
     * TicketTypeCode
     */
    public static final String ADULT_TICKET_TYPE_CODE = "10";

    /**
     * TicketTypeCode
     */
    public static final String SEATFLAG = "1";

    /**
     * TicketTypeCode
     */
    public static final String TICKETKIND = "1";

    /**
     * 目的
     */
    public static final String PURPOSEDCODE = "A1";

    /**
     * ticketChannel:窗口
     */
    public static final String POS = "1";

    /**
     * ticketChannel:互联网
     */
    public static final String INTERNET = "2";

    /**
     * ticketChannel:手持
     */
    public static final String FAD = "3";

    /**
     * payPlatform: 支付平台
     */
    public static final String payPlatform = "POS"; // post支付

    /**
     * 投诉单号前缀
     */
    public static final String COMPLAINT_PREFIX = "C-";

    /**
     * 投诉附件上传前缀
     */
    public static final String COMPLAINT_UPLOAD_NAME_PREFIX = "complaint/";

    /**
     * 成人票种
     */
    public static final String ADULT_CODE = "AUT";

    /**
     * 3-10岁儿童票种
     */
    public static final String CHILD_CODE = "cid";

    /**
     * 10岁以上的儿童票种
     */
    public static final String CHILD_TEN_CODE = "cid10";

    //-------------------------biar-------------------------
    /**
     * 可用状态----可用
     * */
    public static final String ENABLED = "0";
    /**
     * 可用状态----停用
     * */
    public static final String DISABLED = "1";
    /**
     * 文件后缀符号
     * */
    public static final String FILE_DOT = "\\.";

    /**
     * 导出类型----PDF
     * */
    public static final String EXPORT_PDF = "0";

    /**
     * 导出类型----EXCEL
     */
    public static final String EXPORT_EXCEL = "1";

    /**
     * 存根表-车票存根状态-----3-----退票
     */
    public static final Integer TICKET_STUB_STATE_REFUND = 3;
}
