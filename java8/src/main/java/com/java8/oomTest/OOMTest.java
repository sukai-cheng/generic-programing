package com.java8.oomTest;

import java.util.ArrayList;
import java.util.List;

public class OOMTest {

    public static void main(String[] args) {
        List<byte[]> memoryLeakArray = new ArrayList<>();
        for (int i = 0; i < 1024; i++) {
            byte[] tmp = new byte[1024 * 1024];
            memoryLeakArray.add(tmp);
        }
    }
}
