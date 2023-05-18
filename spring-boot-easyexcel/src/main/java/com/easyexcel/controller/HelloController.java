package com.easyexcel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chengsukai
 */
@RestController
@RequestMapping("/stu")
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

}
