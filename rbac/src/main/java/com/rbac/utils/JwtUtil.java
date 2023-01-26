package com.rbac.utils;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.SignatureException;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

public class JwtUtil {
    // Token的有效时间
    public static final Long JWT_TTL = 60 * 60 * 1000L;// 60 * 60 *1000 一个小时
    // 设置秘钥明文
    public static final String JWT_KEY = "afl;ijasifdjaowiejfqoaweisf@$%@$#adfjadkfhqoef319247#$#@!aoedfaopczodf";

    /**
     * 生成 uuid
     *
     * @return uuid
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 生成jwt
     *
     * @param subject token中要存放的数据（json格式，注意不要是私密信息）
     * @return jwt
     */
    public static String createJWT(String subject) {
        JwtBuilder builder = getJwtBuilder(subject, null, getUUID());// 设置过期时间
        return builder.compact();
    }

    /**
     * 生成jwt
     *
     * @param subject   token中要存放的数据（json格式，注意不要是私密信息）
     * @param ttlMillis token超时时间
     * @return jwt
     */
    public static String createJWT(String subject, Long ttlMillis) {
        JwtBuilder builder = getJwtBuilder(subject, ttlMillis, getUUID());// 设置过期时间
        return builder.compact();
    }

    /**
     * @param subject   token中要存放的数据（json格式，注意不要是私密信息）
     * @param ttlMillis token超时时间
     * @param uuid      uuid
     * @return jwt
     */
    private static JwtBuilder getJwtBuilder(String subject, Long ttlMillis, String uuid) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        SecretKey secretKey = generalKey();
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        if (ttlMillis == null) {
            ttlMillis = JwtUtil.JWT_TTL;
        }
        long expMillis = nowMillis + ttlMillis;
        Date expDate = new Date(expMillis);
        return Jwts.builder()
                .setId(uuid) //唯一的id
                .setSubject(subject) // 主题 可以是JSON数据
                .setIssuer("sg") // 签发者
                .setIssuedAt(now) // 签发时间
                .signWith(secretKey, signatureAlgorithm) // 使用HS256对称加密算法签名, 第二个参数为秘钥
                .setExpiration(expDate);
    }

    /**
     * 创建token
     *
     * @param id        用户ID
     * @param subject   token中要存放的数据（json格式，注意不要是私密信息）
     * @param ttlMillis token超时时间
     * @return jwt
     */
    public static String createJWT(String id, String subject, Long ttlMillis) {
        JwtBuilder builder = getJwtBuilder(subject, ttlMillis, id);// 设置过期时间
        return builder.compact();
    }

    public static void main(String[] args) {
        String jwt = createJWT("123456");
        System.out.println(jwt);
    }

    /**
     * 生成加密后的秘钥 secretKey
     *
     * @return secretKey
     */
    public static SecretKey generalKey() {
        byte[] encodedKey = Base64.getEncoder().encode(JwtUtil.JWT_KEY.getBytes());
        return new SecretKeySpec(encodedKey, 0, encodedKey.length, "HmacSHA256");
    }

    /**
     * 解析
     *
     * @param jwt 待解析的jwt
     * @return Claims类型的数据
     */
    public static Claims parseJWT(String jwt) {
        SecretKey secretKey = generalKey();
        Claims claims;
        try {
            claims = Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(jwt).getBody();
        } catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException | SignatureException |
                 IllegalArgumentException e) {
            claims = null;
        }
        return claims;
    }
}
