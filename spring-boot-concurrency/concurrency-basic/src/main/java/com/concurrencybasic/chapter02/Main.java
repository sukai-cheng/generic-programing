package com.concurrencybasic.chapter02;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(3);
        List<Future> list = new ArrayList<>();
        for(int i = 0;i <3; i++){

        }
    }
}
