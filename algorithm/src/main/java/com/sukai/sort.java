package com.sukai;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chengsukai
 * @since 2023-08-28 21:41
 */
public class sort {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 32; i++) {
            list.add(i);
        }
        sort(list);
    }

    public static void sort(List<Integer> arr) {
        int i = 0;
        int j = arr.size() - 1;
        int mid = (i + j) >> 1;
        while (i < j) {
            if (arr.get(i) < arr.get(j)) {
                i++;
                j--;
            }
        }

    }
}
