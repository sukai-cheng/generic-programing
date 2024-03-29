package com.sukai;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author chengsukai
 */
@SpringBootApplication
@EnableDubbo
public class DubboDemoServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(DubboDemoServiceApplication.class, args);
    }
}
