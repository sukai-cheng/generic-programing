package com.rbac.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;

import javax.crypto.SecretKey;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Data
public class JwtTokenUtil implements Serializable {

    private String secret;
    private Long expiration;
    private String header;
    private SecretKey key;

    public JwtTokenUtil() {
    }

    private String generateToken(Map<String, Object> claims) {
        this.setKey(Keys.hmacShaKeyFor(Decoders.BASE64URL.decode(secret)));
        Date expirationDate = new Date(System.currentTimeMillis() + expiration);
        return Jwts.builder().setClaims(claims).setExpiration(expirationDate).signWith(key, SignatureAlgorithm.HS512).compact();
    }

    private Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();

        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>(2);
        claims.put("sub", userDetails.getUsername());
        claims.put("created", new Date());
        return generateToken(claims);

    }

    public String getUsernameFromToken(String token) {
        String username;
        try {
            Claims claims = getClaimsFromToken(token);
            username = claims.getSubject();

        } catch (Exception e) {
            username = null;

        }
        return username;

    }

    public Boolean isTokenExpired(String token) {
        try {
            Claims claims = getClaimsFromToken(token);
            Date expiration = claims.getExpiration();
            return expiration.before(new Date());
        } catch (Exception e) {
            return false;
        }
    }

    public String refreshToken(String token) {
        String refreshedToken;
        try {
            Claims claims = getClaimsFromToken(token);
            claims.put("created", new Date());
            refreshedToken = generateToken(claims);

        } catch (Exception e) {
            refreshedToken = null;

        }
        return refreshedToken;
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        JwtUser user = (JwtUser) userDetails;
        String username = getUsernameFromToken(token);
        return (username.equals(user.getUsername()) && !isTokenExpired(token));

    }
}
