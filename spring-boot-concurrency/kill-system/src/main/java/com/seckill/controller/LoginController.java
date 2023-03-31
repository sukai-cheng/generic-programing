package com.seckill.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
@Slf4j
public class LoginController {

    /**
     * 跳转登陆页面
     * @return
     */
    @RequestMapping("toLogin")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("doLogin")
    public
}
