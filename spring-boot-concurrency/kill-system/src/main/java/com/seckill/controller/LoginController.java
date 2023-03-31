package com.seckill.controller;

import com.seckill.service.TUserService;
import com.seckill.vo.LoginVo;
import com.seckill.vo.RespBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/login")
@Slf4j
public class LoginController {

    @Resource
    private TUserService tUserService;

    /**
     * 跳转登陆页面
     *
     * @return
     */
    @RequestMapping("toLogin")
    public String toLogin() {
        return "login";
    }

    /**
     * 登陆功能
     * @param loginVo
     * @return
     */
    @RequestMapping("doLogin")
    @ResponseBody
    public RespBean doLogin(LoginVo loginVo) {
        log.info("request param: {}", loginVo);
        return tUserService.doLogin(loginVo);
    }
}
