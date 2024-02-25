package com.java8.abstractclazz;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class ClassDemo {

    public static void main(String[] args) throws ParseException {
        Date date = new Date(1676044800000L);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String dateStr2 = sdf.format(date);
        System.out.println(dateStr2);

    }
}

abstract class A {
    public A() {
        System.out.println("*****A类构造方法*****");
    }

    public void hello(){
        System.out.println("hello A");
    }

    public abstract void print();
}

class B extends A {

    public B() {
        System.out.println("*****B类构造方法*****");
    }

    public void hello(){
        System.out.println("hello B");
    }

    @Override
    public void print() {
        System.out.println("Hello World !");
    }
}
