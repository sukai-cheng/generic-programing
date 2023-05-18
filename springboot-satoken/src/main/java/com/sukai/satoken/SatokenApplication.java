package com.sukai.satoken;

import cn.dev33.satoken.SaManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author chengsukai
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class SatokenApplication {
    public static void main(String[] args) {
        SpringApplication.run(SatokenApplication.class, args);
        System.out.println(SaManager.getConfig());
    }


}