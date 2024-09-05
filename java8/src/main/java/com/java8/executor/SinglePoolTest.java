package com.java8.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class SinglePoolTest {
    public static final int SLEEP_GAP = 500;

    public static void main(String[] args) throws InterruptedException {

        // 单线程化线程池
        ExecutorService singlePool = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 5; i++) {
            // 提交5个任务
            singlePool.execute(new Task());
            singlePool.submit(new Task());
        }
        Thread.sleep(1000);
        singlePool.shutdown();
    }

    static class Task implements Runnable {
        static AtomicInteger taskNo = new AtomicInteger(1);
        private String taskName;

        public Task() {
            taskName = "task-" + taskNo.get();
            taskNo.incrementAndGet();
        }

        @Override
        public void run() {
            System.out.println("task:" + taskName + " run start...");
            try {
                Thread.sleep(SLEEP_GAP);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("task" + taskName + " run end...");
        }
    }
}
