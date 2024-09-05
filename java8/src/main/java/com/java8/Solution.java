package com.java8;

import org.checkerframework.checker.units.qual.A;

import java.util.*;

public class Solution {

    int appearMostTimes = -1;
    int appearMostVal = -1;

    /**
     * 出现大多数元素
     */
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> countedMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (countedMap.get(i) != null) {
                int count = countedMap.get(nums[i]);
                countedMap.put(nums[i], count + 1);
            } else {
                countedMap.put(nums[i], 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : countedMap.entrySet()) {
            int count = entry.getValue();
            int key = entry.getKey();
            if (count > appearMostTimes) {
                appearMostTimes = count;
                appearMostVal = key;
            }
        }

        return appearMostVal;

    }

    /**
     * 记忆化 DP
     */
    public int Fibonacci(int n) {
        if (n <= 1) return n;
        // 初始化memo
        int[] memo = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            memo[i] = -1;
        }
        return fib(n, memo);
    }

    /**
     * 辅助函数 - 记忆化DP
     */
    public static int fib(int n, int[] memo) {
        if (memo[n] != -1) return memo[n];
        if (n <= 2) {
            memo[n] = 1;
        } else {
            memo[n] = fib(n - 1, memo) + fib(n - 2, memo);
        }
        return memo[n];
    }

    /**
     * 最长公共前缀
     */
    public String longestCommonPrefix(String[] strs) {

        int lo = 0, hi = strs.length - 1;
        return splitStr(strs, lo, hi);
    }

    private String splitStr(String[] str, int lo, int hi) {
        StringBuilder sb = new StringBuilder();
        if (lo == hi) {
            return str[lo];
        } else {
            int mid = lo + (hi - lo) / 2;
            String leftRes = splitStr(str, lo, mid);
            String rightRes = splitStr(str, mid + 1, hi);
            // 双路归并
            if (leftRes.length() >= rightRes.length()) {
                for (int i = 0; i < rightRes.length(); i++) {
                    if (rightRes.charAt(i) == leftRes.charAt(i)) {
                        sb.append(rightRes.charAt(i));
                    } else {
                        return sb.toString();
                    }
                }
            } else {
                for (int i = 0; i < leftRes.length(); i++) {
                    if (rightRes.charAt(i) == leftRes.charAt(i)) {
                        sb.append(leftRes.charAt(i));
                    } else {
                        return sb.toString();
                    }
                }
            }
            return sb.toString();
        }
    }

    /**
     * 最后一个单词的长度
     */
    public int lengthOfLastWord(String s) {
        int count = 0;
        s = s.trim();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                count++;
            }
            if (s.charAt(i) == ' ' && i != s.length() - 1) {
                return count;
            }
        }

        return count;
    }

    /**
     * 找出字符串中第一个匹配项的下标
     */
    public int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) {
            return -1;
        }
        int lp = 0;
        int rp = 0;
        for (int i = 0, j = 0; i < haystack.length(); i++, j++) {
            if (j < needle.length() && needle.charAt(j) == haystack.charAt(i)) {
                rp++;
            } else {
                if (rp - lp < needle.length()) {
                    lp++;
                    rp = lp;
                    i = lp - 1;
                    j = -1;
                } else {
                    return lp;
                }

            }
        }
        if (rp - lp < needle.length()) {
            return -1;
        } else {
            return lp;
        }
    }

    /**
     * 字符串反转
     */
    public String reverseWords(String s) {
        String str = s.trim();
        StringBuilder sb = new StringBuilder();
        String[] strArr = str.split(" +");
        for (int i = strArr.length - 1; i >= 0; i--) {
            sb.append(strArr[i]);
            if (i != 0) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    /**
     * 删除有序数组中的重复项
     */
    public int removeDuplicates(int[] nums) {
        int res = 1;
        return removeDuplicatesRecursion(nums, 0, nums.length, res);
    }

    private int removeDuplicatesRecursion(int[] nums, int lo, int hi, int res) {
        if (lo == hi) {
            return nums[lo];
        } else {
            int mid = lo + (hi - lo) / 2;
            int leftVal = removeDuplicatesRecursion(nums, lo, mid, res);
            int rightVal = removeDuplicatesRecursion(nums, mid + 1, hi, res);
            if (leftVal != rightVal) {
                return res + 1;
            } else {
                return res;
            }
        }
    }

    /**
     * 判断子序列
     */
    public boolean isSubsequence(String s, String t) {
        int p = 0;
        int q = 0;
        while(q < t.length() && p < s.length()){
            if(s.charAt(p) == t.charAt(q)){
                p++;
                q++;
            }else{
                p++;
            }
        }
        if(q == s.length()){
            return true;
        }else{
            return false;
        }
    }

    private int[] initStatus(String s) {
        int[] status = new int[s.length()];
        Arrays.fill(status, 0);
        return status;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isSubsequence("ahbgdc", "abc"));
//        solution.removeDuplicates(new int[]{1, 1, 2});
        // System.out.println(solution.strStr("a", "a"));
        // System.out.println(solution.reverseWords("the sky       is   blue"));
        // System.out.println(solution.strStr("leetcode", "leeto"));
        // System.out.println(solution.lengthOfLastWord("   fly me   to   the moon  "));
        // String[] strings = new String[]{"flower","flow","flight"};
        // System.out.println(solution.longestCommonPrefix(strings));
        // int[] arr = {2, 2, 1, 1, 1, 2, 2};
        // System.out.println(solution.majorityElement(arr));

    }


}






















