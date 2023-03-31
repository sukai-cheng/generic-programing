package com.seckill;

import com.github.jeffreyning.mybatisplus.conf.EnableMPP;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.seckill.mapper")
public class SeckillSpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(SeckillSpringBootApplication.class, args);
    }
}
