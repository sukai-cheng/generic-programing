package com.sukai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


/**
 * @author chengsukai
 * @since 2022-07-10 22:31
 */
@SpringBootApplication(exclude= DataSourceAutoConfiguration.class)

public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
