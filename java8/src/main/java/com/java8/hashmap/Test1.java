package com.java8.hashmap;

import java.util.HashMap;

/**
 * @author chengsukai
 */
public class Test1 {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        String val = map.put("name", "chengsukai");
        map.put("name","sukai");
    }
}
