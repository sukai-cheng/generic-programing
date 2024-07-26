package com.java8.forkJoinPool;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class Test1 {
    public static void main(String[] args) throws Exception {
        ForkJoinPool pool = new ForkJoinPool();
        pool.submit(new TaskDemo(0, 1000));
        pool.awaitTermination(2, TimeUnit.SECONDS);
        pool.shutdown();
    }
}
