package com.redis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * spring-boot-redis
 * @author chengsukai
 */
@SpringBootApplication
@MapperScan("com.redis.mapper")
public class RedisSpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(RedisSpringBootApplication.class, args);
    }
}
