package com.java8.hashmap;

import java.util.HashMap;

public class Test3 {

    public static void main(String[] args) {

        HashMap<String, String> keyIsNullHashMap = new HashMap<>();
        keyIsNullHashMap.put(null, "null key1");
        keyIsNullHashMap.put(null, "null key2");
        System.out.println(keyIsNullHashMap);
    }
}
