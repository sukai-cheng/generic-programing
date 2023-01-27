package com.rbac.controller;

import com.rbac.entity.SysUser;
import com.rbac.service.login.impl.LoginServiceImpl;
import com.rbac.utils.ResponseResult;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class Test {

    @Resource
    private LoginServiceImpl loginService;

    @PostMapping("/login")
    public ResponseResult<?> login(@RequestBody SysUser user) {

        return loginService.login(user);

    }
}
