package com.concurrencybasic.atomicReference;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author chengsukai
 */
public class AtomicReferenceTest {

    public static void main(String[] args) {
        // AtomicReference<SimpleObject> atomicReference = new AtomicReference<>();
        // atomicReference.set(new SimpleObject("test1",10));
//        AtomicReference<SimpleObject> atomicReference = new AtomicReference<>(new SimpleObject("test1", 10));
//        SimpleObject simpleObject = atomicReference.get();
//        System.out.println("simpleObject Value: " + simpleObject.toString());

//        SimpleObject simpleObject = new SimpleObject("test3", 30);
//        AtomicReference<SimpleObject> atomicReference = new AtomicReference<>(simpleObject);
        // 如果当前期盼的值是simpleObject
//        atomicReference.compareAndSet(simpleObject, new SimpleObject("test4", 40));
//        System.out.println(atomicReference.get().toString());

        SimpleObject test1 = new SimpleObject("test5", 50);
        AtomicReference<SimpleObject> atomicReference3 = new AtomicReference<>(test1);
        // 返回旧值
        SimpleObject test6 = atomicReference3.getAndSet(new SimpleObject("test6", 50));
        SimpleObject simpleObject1 = atomicReference3.get();
        System.out.println(test6.toString());
        System.out.println(simpleObject1.toString());
    }
}
