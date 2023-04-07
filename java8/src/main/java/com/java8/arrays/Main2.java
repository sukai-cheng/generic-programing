package com.java8.arrays;

import java.util.ArrayList;
import java.util.List;

public class Main2 {

    public static void main(String[] args) {
        List<String> bookList = new ArrayList<>();
        bookList.add("遥远的救世主");
        bookList.add("背叛");
        bookList.add("天幕红尘");
        bookList.add("人生");
        bookList.add("平凡的世界");

        // 返回的是原集合的一个视图, 修改原集合的值会报ConcurrentModificationException
        List<String> luyaoBookList = bookList.subList(3, 5);

        System.out.println(bookList);
        System.out.println(luyaoBookList);
    }
}
