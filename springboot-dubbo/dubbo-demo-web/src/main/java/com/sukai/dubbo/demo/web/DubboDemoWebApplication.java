package com.sukai.dubbo.demo.web;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author chengsukai
 */
@SpringBootApplication
@EnableDubbo
public class DubboDemoWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(DubboDemoWebApplication.class, args);
    }
}
