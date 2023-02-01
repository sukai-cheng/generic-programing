package com.designpattern.factorypattern.caseI;

/**
 * 静态内部类（延迟初始化占位类）
 * 静态初始化器是由JVM在类的初始化阶段执行，即在类被加载后并且被线程使用之前。
 * 由于JVM将在初始化期间获得一个锁，并且每个线程都至少获取一次这个锁以确保这个类已经加载。
 * 因此在静态初始化期间，内存写入操作将自动对所有线程可见。
 */
public class SingletonStatic {
    private static class SingletonHolder {
        private static final SingletonStatic INSTANCE = new SingletonStatic();
    }

    private SingletonStatic() {
    }

    public static SingletonStatic getInstance() {
        return SingletonHolder.INSTANCE;
    }

}
