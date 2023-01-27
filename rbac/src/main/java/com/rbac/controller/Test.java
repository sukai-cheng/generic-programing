package com.rbac.controller;

import com.rbac.entity.SysUser;
import com.rbac.service.login.impl.LoginServiceImpl;
import com.rbac.service.login.impl.UserDetailsServiceImpl;
import com.rbac.utils.ResponseResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;

@RestController
@RequestMapping("/user")
public class Test {

    @Resource
    private LoginServiceImpl loginService;

    @Resource
    private UserDetailsServiceImpl userDetailsService;

    @GetMapping("/login")
    public ResponseResult<?> login() {


        ArrayList<SysUser> list = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            list.add(initSysUser(i));
        }
        userDetailsService.save(list);

        return new ResponseResult<>();

    }

    private SysUser initSysUser(Integer no) {
        SysUser loginUser = new SysUser();
        loginUser.setUserName("chengsukai" + no);
        loginUser.setNickName("chengsukai" + no);
        loginUser.setEmail("chengsukai@gmail.com");
        loginUser.setPassword("123456");
        loginUser.setSex("0");
        loginUser.setAvatar("www.avatar.com");
        loginUser.setRemark("Hello , my name is chengsukai");
        loginUser.setStatus("0");
        loginUser.setUserType("0");
        loginUser.setDelFlag("0");

        return loginUser;
    }

}
