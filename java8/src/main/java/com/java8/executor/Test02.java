package com.java8.executor;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

@Slf4j
public class Test02 {

    @Test
    public void test() {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        CompletionService<String> executorCompletionService = new ExecutorCompletionService<>(executorService);
        List<Future<String>> futures = new ArrayList<>();
        addCompletionFuture(futures, executorCompletionService);
        for (Future<String> future : futures) {
            try {
                log.info("result,{}", executorCompletionService.take().get());
                break;
            } catch (Exception e) {
                log.error("get error: ", e);
            }finally {
                future.cancel(true);
            }
        }
    }

    private void addCompletionFuture(List<Future<String>> futures, CompletionService<String> executorCompletionService) {
        futures.add(executorCompletionService.submit(() -> {
            TimeUnit.SECONDS.sleep(10);
            return "A";
        }));
        futures.add(executorCompletionService.submit(() -> {
            TimeUnit.SECONDS.sleep(2);
            return "B";
        }));
        futures.add(executorCompletionService.submit(() -> {
            TimeUnit.SECONDS.sleep(3);
            return "C";
        }));
        futures.add(executorCompletionService.submit(() -> {
            TimeUnit.SECONDS.sleep(4);
            return "D";
        }));
    }
}
