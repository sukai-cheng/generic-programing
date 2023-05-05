package com.concurrencybasic.chapter03;

/**
 * @author chengsukai
 */
public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        test.add();
    }
    int i = 0;
    public void add(){
        synchronized (this){
            i++;
        }
    }
}
