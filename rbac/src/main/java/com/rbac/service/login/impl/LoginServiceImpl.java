package com.rbac.service.login.impl;

import com.rbac.entity.LoginUser;
import com.rbac.entity.SysUser;
import com.rbac.service.login.LoginService;
import com.rbac.utils.JwtUtil;
import com.rbac.utils.RedisCache;
import com.rbac.utils.ResponseResult;
import jakarta.annotation.Resource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    private AuthenticationManager authenticationManager;

    @Resource
    private RedisCache redisCache;


    @Override
    public ResponseResult<?> login(SysUser user) {

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword());

        Authentication authenticate = authenticationManager.authenticate(authenticationToken);

        if (Objects.isNull(authenticate)) {
            throw new RuntimeException("username or password error");
        }

        // 如果认证通过，使用user生成jwt， jwt存入结果中

        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();

        String userId = loginUser.getUser().getUserId().toString();

        String jwt = JwtUtil.createJWT(userId);

        Map<String, String> map = new HashMap<>();

        map.put("token", jwt);

        redisCache.setCacheObject("login: " + userId, loginUser);

        return new ResponseResult<>(200, "login successfully", map);
    }

    @Override
    public ResponseResult<?> logout() {

        UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();

        LoginUser loginUser = (LoginUser) authentication.getPrincipal();

        Long userId = loginUser.getUser().getUserId();

        redisCache.deleteObject("login: " + userId);

        return new ResponseResult<>(200, "logout successfully");

    }
}


























