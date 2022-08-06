package com.sukai.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author chengsukai
 * @since 2022-07-10 22:32
 */
@Controller
public class BootController {

    @GetMapping("/user/account")
    @ResponseBody
    public String queryData() {
        return "访问user/account地址";
    }


    @GetMapping("/user/login")
    @ResponseBody
    public String userLogin() {
        return "访问userLogin地址";
    }
}
