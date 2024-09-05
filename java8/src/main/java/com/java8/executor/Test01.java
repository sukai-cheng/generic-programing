package com.java8.executor;


import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

@Slf4j
public class Test01 {

    @Test
    public void Test() {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        List<Future<String>> futures = new ArrayList<>();
        addExecutorFuture(futures, executorService);
        for (Future future : futures) {
            try {
                log.info("result,{}", future.get());
            } catch (Exception e) {
                log.error("get error: ", e);
            }
        }
    }

    private static void addExecutorFuture(List<Future<String>> futures, ExecutorService executorService) {
        futures.add(executorService.submit(()->{
            TimeUnit.SECONDS.sleep(10);
            return "A";
        }));
        futures.add(executorService.submit(()->{
            TimeUnit.SECONDS.sleep(2);
            return "B";
        }));
        futures.add(executorService.submit(()->{
            TimeUnit.SECONDS.sleep(3);
            return "C";
        }));
        futures.add(executorService.submit(()->{
            TimeUnit.SECONDS.sleep(4);
            return "D";
        }));
    }
}
