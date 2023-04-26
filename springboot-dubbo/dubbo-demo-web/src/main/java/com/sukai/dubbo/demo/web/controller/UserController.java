package com.sukai.dubbo.demo.web.controller;

import com.sukai.dubbo.demo.api.DemoApi;
import org.springframework.data.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chengsukai
 */
@RestController
public class UserController {

    @Reference
    private DemoApi demoApi;

    @GetMapping("/hello/{msg}")
    public String hello(@PathVariable("msg") String msg) {
        return demoApi.sayHello(msg);
    }
}
