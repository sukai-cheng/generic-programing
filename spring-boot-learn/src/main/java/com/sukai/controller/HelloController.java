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
public class HelloController {

    @Value("${server.port}")
    private Integer port;

    @Value("${server.servlet.context-path}")
    private String contextPath;

    @Value("${school.name}")
    private String name;

    @Value("${school.website}")
    private String site;

    @Value("${school.address}")
    private String address;

    @GetMapping("/test")
    @ResponseBody
    public String queryData() {
        return "name=" + name + ", site=" + site + ", address=" + address;
    }
}
