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
            } catch (Exception e) {
                log.error("get error: ", e);
            }
        }
    }

    private void addCompletionFuture(List<Future<String>> futures, CompletionService<String> executorCompletionService) {
        List<Callable<String>> taskList = mockTaskList();
        submitTask(futures, executorCompletionService, taskList);
    }

    private List<Callable<String>> mockTaskList() {
        List<Callable<String>> taskList = new ArrayList<>();
        taskList.add(() -> {
            TimeUnit.SECONDS.sleep(10);
            return "A";
        });
        taskList.add(() -> {
            TimeUnit.SECONDS.sleep(2);
            return "B";
        });
        taskList.add(() -> {
            TimeUnit.SECONDS.sleep(3);
            return "C";
        });
        taskList.add(() -> {
            TimeUnit.SECONDS.sleep(4);
            return "D";
        });

        return taskList;
    }

    private void submitTask(List<Future<String>> futures, CompletionService<String> completionService, List<Callable<String>> taskList) {

        for (Callable<String> task : taskList) {
            futures.add(completionService.submit(task));
        }
    }
}
