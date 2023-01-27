package com.rbac.component;

import cn.hutool.http.HttpStatus;
import cn.hutool.json.JSONUtil;
import com.rbac.utils.ResponseResult;
import com.rbac.utils.WebUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) {
        ResponseResult<Object> result = new ResponseResult<>(HttpStatus.HTTP_UNAUTHORIZED, "认证失败");
        String json = JSONUtil.toJsonStr(result);
        WebUtils.renderString(response, json);
    }
}
