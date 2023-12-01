package com.java8.bigdecimal;

import java.math.BigDecimal;

/**
 * 为了避免在bigdecimal中的精度问题, 统一传字符串格式的数据
 */
public class test01 {
    public static void main(String[] args) {
        BigDecimal bigDecimal1 = new BigDecimal("0.01");
        BigDecimal bigDecimal2 = BigDecimal.valueOf(0.01);
        System.out.println(bigDecimal1.equals(bigDecimal2));
        System.out.println(bigDecimal1.compareTo(bigDecimal2));
    }
}
