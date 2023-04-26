package com.sukai.dubbo.demo.web.Task;

import com.sukai.dubbo.demo.api.DemoApi;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author chengsukai
 */
@Component
public class Task implements CommandLineRunner {

    @DubboReference
    private DemoApi demoApi;

    @Override
    public void run(String... args) throws Exception {
        String result = demoApi.sayHello("world");
        System.out.println("Receive result ======> " + result);

        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                    System.out.println(new Date() + "Receive result =====> " + demoApi.sayHello("world"));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            }
        }).start();
    }
}
