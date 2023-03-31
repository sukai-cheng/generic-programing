package com.concurrencybasic.chapter01;

public class Main {
    public static void main(String[] args) {
        ClassA a = new ClassA();
        ClassB b = new ClassB();
        System.out.println(a.getClass().getName());
        System.out.println(b.getClass().getName());
    }
}
