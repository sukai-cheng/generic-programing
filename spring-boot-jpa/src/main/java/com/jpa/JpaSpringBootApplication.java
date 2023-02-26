package com.jpa;

import com.github.jeffreyning.mybatisplus.conf.EnableMPP;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@SpringBootApplication
public class JpaSpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(JpaSpringBootApplication.class, args);
    }
}
