package com.seckill.utils;

import org.apache.commons.codec.cli.Digest;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

/**
 * MD5工具类
 */
@Component
public class MD5Util {

    /**
     * md5加密
     *
     * @param src
     * @return
     */
    public static String md5(String src) {
        return DigestUtils.md5Hex(src);
    }

    private static final String salt = "1a2b3c4d";

    private static String inputPassword2ServerPass(String inputPass) {
        // 混淆
        String str = salt.charAt(0) + salt.charAt(2) + inputPass + salt.charAt(5) + salt.charAt(4);

        // md5加密
        return md5(str);
    }

    /**
     * @param serverPass
     * @param salt
     * @return
     */
    private static String serverPass2DataBasePass(String serverPass, String salt) {

        String str = salt.charAt(0) + salt.charAt(2) + serverPass + salt.charAt(5) + salt.charAt(4);

        return md5(str);

    }

    public static String inputPass2DataBasePass(String inputPass, String salt){
        String serverPass = inputPassword2ServerPass(inputPass);
        String dbPass = serverPass2DataBasePass(serverPass, salt);
        return dbPass;
    }


}
