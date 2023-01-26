package com.rbac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class RbacSpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(RbacSpringBootApplication.class, args);
    }
}
