package com.java8.designPattern;

import org.apache.commons.lang3.SerializationUtils;

import java.io.Serializable;
import java.lang.reflect.Constructor;

/**
 * 单例模式的几种写法
 */
public class DifferentSingleton {

    public static void main(String[] args) throws Exception {
        UnsafeSingleton3 s = UnsafeSingleton3.getInstance();

//         反射
//        Constructor<UnsafeSingleton3> constructor = UnsafeSingleton3.class.getDeclaredConstructor();
//        constructor.setAccessible(true);
//        UnsafeSingleton3 sReflection = constructor.newInstance();
//        System.out.println(s);
//        System.out.println(sReflection);
//        System.out.println(s == sReflection);
//
//        序列化

//        byte[] serialize = SerializationUtils.serialize(s);
//        Object deserialize = SerializationUtils.deserialize(serialize);
//        System.out.println(s);
//        System.out.println(deserialize);
//        System.out.println(s == deserialize);

        UnsafeSingleton6.INSTANCE.fun();
    }

    /**
     * ad: 满足单例
     * bad: 线程安全问题,无法防止反序列化重新创建新的对象
     */
    static class UnsafeSingleton{
        private static UnsafeSingleton instance;
        private UnsafeSingleton() {}

        public static UnsafeSingleton getInstance() {
            if(instance == null) {
                instance = new UnsafeSingleton();
            }
            return instance;
        }
    }

    /**
     * ad: 使用同步锁 synchronized 保证线程安全
     * bad: 效率低,无法防止反序列化重新创建新的对象
     */
    static class UnsafeSingleton2{
        private static UnsafeSingleton2 instance;
        private UnsafeSingleton2() {}

        public static synchronized UnsafeSingleton2 getInstance() {
            if(instance == null) {
                instance = new UnsafeSingleton2();
            }
            return instance;
        }
    }

    /**
     * ad: 满足单例,线程安全问题
     * bad: 初始化就装载了,没有懒加载,无法防止反序列化重新创建新的对象
     */
    static class UnsafeSingleton3 implements Serializable {
        private static UnsafeSingleton3 instance = new UnsafeSingleton3();
        private UnsafeSingleton3() {}

        public static UnsafeSingleton3 getInstance() {
           return instance;
        }
    }

    /**
     * ad: 满足单例,线程安全,懒加载
     * bad: 无法防止反序列化重新创建新的对象
     */
    static class UnsafeSingleton4{
        // 静态内部类
        private static class SingletonHolder{
            private static final UnsafeSingleton4 INSTANCE = new UnsafeSingleton4();
        }
        private UnsafeSingleton4() {}

        public static UnsafeSingleton4 getInstance() {
            return SingletonHolder.INSTANCE;
        }
    }

    /**
     * ad: 满足单例,线程安全,懒加载
     * bad: 无法防止反序列化重新创建新的对象
     */
    static class UnsafeSingleton5{

        private volatile static UnsafeSingleton5 instance;
        private UnsafeSingleton5() {}

        public static UnsafeSingleton5 getInstance() {
            if(instance == null) {
                synchronized (UnsafeSingleton5.class) {
                    if(instance == null) {
                        instance = new UnsafeSingleton5();
                    }
                }
            }
            return instance;
        }
    }

    /**
     * ad: 满足单例,线程安全,懒加载,防止反序列化重新创建新的对象
     */
    static enum UnsafeSingleton6{
        INSTANCE;
        private void fun(){
            System.out.println(INSTANCE);
        }
    }


}























