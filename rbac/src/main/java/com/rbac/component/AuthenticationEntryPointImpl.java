package com.rbac.component;

import cn.hutool.http.HttpStatus;
import cn.hutool.json.JSONUtil;
import com.rbac.utils.ResponseResult;
import com.rbac.utils.WebUtils;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) {
        ResponseResult<Object> result = new ResponseResult<>(HttpStatus.HTTP_UNAUTHORIZED, "认证失败");
        String json = JSONUtil.toJsonStr(result);
        WebUtils.renderString(response, json);
    }
}
