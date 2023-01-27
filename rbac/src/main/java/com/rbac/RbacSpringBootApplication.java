package com.rbac;

import com.github.jeffreyning.mybatisplus.conf.EnableMPP;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@SpringBootApplication
@MapperScan(value="com.rbac.mapper")
@EnableMPP
public class RbacSpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(RbacSpringBootApplication.class, args);
    }
}
