package com.concurrencybasic.chapter01;

import javax.annotation.concurrent.NotThreadSafe;

/**
 * 非线程安全的序列生成器
 */
@NotThreadSafe
public class UnsafeSequence {
    private int value;

    public int getNext(){
        return value++;
    }
}
