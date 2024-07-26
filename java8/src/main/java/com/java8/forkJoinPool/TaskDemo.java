package com.java8.forkJoinPool;

import java.util.concurrent.RecursiveAction;

public class TaskDemo extends RecursiveAction {

    private static final int MAX = 20;

    private int start;
    private int end;

    public TaskDemo(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {
        if ((end - start) <= MAX) {
            for (int i = start; i < end; i++) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }else{
            int middle = (start + end) / 2;
            TaskDemo left = new TaskDemo(start, middle);
            TaskDemo right = new TaskDemo(middle, end);
            left.fork();
            right.fork();
        }
    }
}
