package com.easyexcel;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.easyexcel.mapper")
public class EasyExcelSpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(EasyExcelSpringBootApplication.class, args);
    }
}
