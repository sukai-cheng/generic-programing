package com.java8.arrays;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Arrays.toList() 不能add
 * @author chengsukai
 */
public class Main {
    public static void main(String[] args) {

        // 返回只读的List
        List<Integer> statusList = Arrays.asList(1,2);
        System.out.println(statusList);
        System.out.println(statusList.contains(1));
        System.out.println(statusList.contains(3));
        statusList.add(3);
        System.out.println(statusList.contains(3));

    }
}
