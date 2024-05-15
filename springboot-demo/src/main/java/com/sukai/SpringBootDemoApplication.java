package com.sukai;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

import javax.annotation.Resource;

/**
 * @author chengsukai
 */
@SpringBootApplication
@ServletComponentScan
@Slf4j
public class SpringBootDemoApplication implements ApplicationRunner {

    @Resource
    private RedissonClient redissonClient;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        // 获取锁
        RLock optimisticLock = redissonClient.getLock("Hello");

        // 锁
        optimisticLock.lock();
        try {
            log.info("locked");
            Thread.sleep(2000);
        } finally {
            // 释放锁
            optimisticLock.unlock();
        }
        log.info("finished");
    }
}
