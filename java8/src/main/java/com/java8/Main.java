package com.java8;

import org.openjdk.jol.info.ClassLayout;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        OneClass oneClass = new OneClass();
        synchronized (oneClass){
            System.out.println(ClassLayout.parseInstance(oneClass).toPrintable());
        }
    }
}
class OneClass{
    boolean flag = false;
}
