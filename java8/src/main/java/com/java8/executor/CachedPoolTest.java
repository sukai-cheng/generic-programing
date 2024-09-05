package com.java8.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class CachedPoolTest {

    // thread sleep time
    public static final int SLEEP_TIME = 500;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService cachedPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            cachedPool.execute(new Task());
            cachedPool.submit(new Task());
        }
        Thread.sleep(1000);
        cachedPool.shutdown();
    }

    static class Task implements Runnable {

        private final String taskName;
        static AtomicInteger taskNo = new AtomicInteger(1);

        public Task(){
            taskName = "task-" + taskNo.get();
            taskNo.incrementAndGet();
        }
        @Override
        public void run() {
            System.out.println("task:" + taskName + " run start...");
            try{
                Thread.sleep(SLEEP_TIME);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("task:" + taskName + " run end...");
        }
    }
}
