package com.concurrencybasic.chapter02;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(3);
        List<Future> list = new ArrayList<>();
        for(int i = 0;i <3; i++){
            Callable c = new MyCallable();
            Future task = pool.submit(c);
            list.add(task);
        }
        pool.shutdown();
        for(Future future : list){
            System.out.println(future.get().toString());
        }
    }

    static class MyCallable implements Callable{

        @Override
        public Object call() throws Exception {
            String mes = "I have done ...";
            return mes;
        }
    }
}
