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

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0;
        int p2 = 0;
        int[] sorted = new int[m + n];

        int cur = 0;

        while (p1 < m || p2 < n) {
            if (p1 == m) {
                cur = nums2[p2++];
            } else if (p2 == n) {
                cur = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {
                cur = nums1[p1++];
            } else {
                cur = nums2[p2++];
            }
            sorted[p1 + p2 - 1] = cur;
        }

        for(int i =0 ; i < sorted.length; i++){
            nums1[i] = sorted[i];
        }

    }
}
