package com.sukai.dubbo.demo.web;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.system.ApplicationHome;

import java.io.File;

/**
 * @author chengsukai
 */
@SpringBootApplication
@EnableDubbo
public class DubboDemoWebApplication {
    public static void main(String[] args) {
        ApplicationHome home = new ApplicationHome(DubboDemoWebApplication.class);
        File jarFile = home.getSource();
        String dirPath = jarFile.getParentFile().toString();
        String filePath = dirPath + File.separator + ".dubbo";
        System.out.println(filePath);

        System.setProperty("dubbo.meta.cache.filePath", filePath);
        System.setProperty("dubbo.mapping.cache.filePath",filePath);
        SpringApplication.run(DubboDemoWebApplication.class, args);
    }
}
