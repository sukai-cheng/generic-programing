package com.seckill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/demo")
public class DemoController {

    /**
     * 功能描述: <br>
     * 测试页面跳转
     * @param model
     * @return
     * @since: 1.0.0
     * @Authro: sukai
     */
    @RequestMapping("/hello")
    public String hello(Model model){
        model.addAttribute("name","承苏凯");
        return "hello";
    }
}
