package com.rbac.component;

import cn.hutool.http.HttpStatus;
import cn.hutool.json.JSONUtil;
import com.rbac.utils.ResponseResult;
import com.rbac.utils.WebUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;


public class AccessDeniedHandlerImpl implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) {
        ResponseResult<Object> result = new ResponseResult<>(HttpStatus.HTTP_FORBIDDEN, "权限不足");
        String json = JSONUtil.toJsonStr(result);
        WebUtils.renderString(response, json);
    }
}
