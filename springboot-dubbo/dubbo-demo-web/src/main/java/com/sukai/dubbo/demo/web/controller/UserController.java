package com.sukai.dubbo.demo.web.controller;

import com.sukai.dubbo.demo.api.DemoApi;
import com.sukai.dubbo.demo.request.DemoRequest;
import com.sukai.dubbo.demo.response.DemoResponse;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

/**
 * @author chengsukai
 */
@RestController
public class UserController {

    @DubboReference(version = "1.0.0", group = "dev", timeout = 5000) // 获取RPC订阅
    private DemoApi demoApi;

    @GetMapping("/hello/{msg}")
    public String hello(@PathVariable("msg") String msg) {
        return demoApi.sayHello(msg);
    }

    @PostMapping("/test/post")
    public DemoResponse testPost(@RequestBody DemoRequest request){

        return demoApi.postRequestDemo(request);
    }
}
