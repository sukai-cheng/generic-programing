package com.java8.abstractclazz;

import lombok.Data;

import java.util.Date;
import java.util.TimeZone;

public class Test {
    public static void main(String[] args) {
        long times = 1675958400000L;
//        1675958400000
        Date date = new Date(times);
        System.out.println(date);

    }
}
