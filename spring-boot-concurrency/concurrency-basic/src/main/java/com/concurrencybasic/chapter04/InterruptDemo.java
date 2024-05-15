package com.concurrencybasic.chapter04;

import cn.hutool.cron.task.Task;

import java.util.concurrent.BlockingQueue;

public class InterruptDemo implements Runnable {
        BlockingQueue<Task> queue;

    @Override
    public void run() {
        try {
            queue.take();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }
}
