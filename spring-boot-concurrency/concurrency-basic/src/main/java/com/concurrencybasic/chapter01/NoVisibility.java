package com.concurrencybasic.chapter01;

import java.sql.SQLOutput;

public class NoVisibility {

    // 共享变量
    private volatile static boolean ready = false;
    private volatile static int number;

    private static class ReaderThread extends Thread {
        public void run(){
            while (!ready){
                Thread.yield();
                System.out.println(number);
            }
        }
    }

    public static void main(String[] args) {

        new ReaderThread().start();
        number = 42;
        ready = true;
    }
}







