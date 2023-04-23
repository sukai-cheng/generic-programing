package com.seckill;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author chengsukai
 */
@SpringBootApplication
@MapperScan("com.seckill.mapper")
public class SeckillSpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(SeckillSpringBootApplication.class, args);
    }
}
