package com.concurrencybasic.chapter02;

public class MyThread implements Runnable{
    @Override
    public void run() {
        System.out.println("MyThread.run()");
    }

    public static void main(String[] args) {
        MyThread thread = new MyThread();
        Thread thread1 = new Thread(thread);
        thread1.start();
    }
}


