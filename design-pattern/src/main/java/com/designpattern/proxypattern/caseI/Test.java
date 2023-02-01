package com.designpattern.proxypattern.caseI;

/**
 * @description
 *
 * @author chengsukai
 *
 * @create 2022-05-04 13:59
 **/
public class Test {
    public static void main(String[] args) {

        Zhanglaosan zhanglaosan = new Zhanglaosan(new Zhangsan());
        zhanglaosan.findTeacher();
    }
}