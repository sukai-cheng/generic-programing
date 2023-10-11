package com.sukai.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chengsukai
 */
@RestController
public class TestController {

    @GetMapping("/hello")
    public String hello() {
        return "hello, springboot is up ";
    }
}
