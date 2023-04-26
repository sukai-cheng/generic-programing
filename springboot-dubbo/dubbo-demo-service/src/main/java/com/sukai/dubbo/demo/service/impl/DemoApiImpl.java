package com.sukai.dubbo.demo.service.impl;

import com.sukai.dubbo.demo.api.DemoApi;
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
}
