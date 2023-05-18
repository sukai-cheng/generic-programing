package com.sukai.satoken.controller;

import cn.dev33.satoken.stp.StpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author chengsukai
 */
@RestController
@RequestMapping("/user/")
@Slf4j
public class UserController {

    @RequestMapping("doLogin")
    public String doLogin(String username, String password) {
        if ("zhang".equals(username) && "123456".equals(password)) {
            StpUtil.login(10001);
            return "登陆成功";
        }
        return "登陆失败";
    }


    @RequestMapping("isLogin")
    public String login() {
        return "当前会话是否登陆: " + StpUtil.isLogin();
    }

    @RequestMapping("showPermissionList")
    public void showPermissionList(){
        List<String> permissionList = StpUtil.getPermissionList();
        log.info(permissionList.toString());
    }

}
