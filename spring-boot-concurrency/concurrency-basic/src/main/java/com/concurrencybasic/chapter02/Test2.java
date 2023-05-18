package com.concurrencybasic.chapter02;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author chengsukai
 */
public class Test2 {
    public static void main(String[] args) {

        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        while (true) {
            threadPool.execute(() -> {
                System.out.println(Thread.currentThread().getName() + "is running ..");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

    }
}
