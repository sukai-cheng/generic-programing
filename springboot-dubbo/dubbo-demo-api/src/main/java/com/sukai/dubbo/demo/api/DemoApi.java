package com.sukai.dubbo.demo.api;

import com.sukai.dubbo.demo.request.DemoRequest;
import com.sukai.dubbo.demo.response.DemoResponse;

/**
 * @author chengsukai
 */
public interface DemoApi {
    String sayHello(String name);

    DemoResponse postRequestDemo(DemoRequest request);
}
