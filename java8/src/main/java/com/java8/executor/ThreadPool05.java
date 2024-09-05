package com.java8.executor;

import java.util.concurrent.*;

public class ThreadPool05 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        final int corePoolSize = 2;
        final int maximumPoolSize = 4;
        final int keepAliveTime = 10000;
        final TimeUnit unit = TimeUnit.MILLISECONDS;
        LinkedBlockingQueue queue = new LinkedBlockingQueue<>();
        ThreadFactory factory = Thread::new;
        RejectedExecutionHandler handler = new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {

            }
        };
        ThreadPoolExecutor pool = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, queue, factory, handler);
        pool.execute(() -> {
            System.out.println("ThreadPoolExecutor execute Runnable task...");
        });
        pool.submit(() -> {
            System.out.println("ThreadPoolExecutor submit Runnable task...");
        });
        Future<String> future = pool.submit(() -> {
            System.out.println("ThreadPoolExecutor submit Callable task...");
            return "Callable";
        });
        Thread.sleep(1000L);
        pool.shutdown();
        System.out.println("执行结果:" + future.get());
    }
}
