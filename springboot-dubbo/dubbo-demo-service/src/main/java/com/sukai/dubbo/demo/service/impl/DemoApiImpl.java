package com.sukai.dubbo.demo.service.impl;

import com.sukai.dubbo.demo.api.DemoApi;
import com.sukai.dubbo.demo.request.DemoRequest;
import com.sukai.dubbo.demo.response.DemoResponse;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author chengsukai
 */
@DubboService(version = "1.0.0", group = "dev", timeout = 5000) //发布dubbo服务
public class DemoApiImpl implements DemoApi {

    @Override
    public String sayHello(String name) {
        return "Hello, " + name + "(from Spring Boot with dubbo-2.7.1)";
    }

    @Override
    public DemoResponse postRequestDemo(DemoRequest request) {
        DemoResponse response = new DemoResponse();
        response.setMessage(request.getUsername() + " " + request.getPassword());
        response.setStatus("true");
        return response;
    }
}
