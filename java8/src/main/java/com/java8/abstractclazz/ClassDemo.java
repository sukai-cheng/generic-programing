package com.java8.abstractclazz;

public class ClassDemo {

    public static void main(String[] args) {
        A a = new B();
    }
}

abstract class A {
    public A() {
        System.out.println("*****A类构造方法*****");
    }

    public void hello(){
        System.out.println("hello A");
    }

    public abstract void print();
}

class B extends A {

    public B() {
        System.out.println("*****B类构造方法*****");
    }

    public void hello(){
        System.out.println("hello B");
    }

    @Override
    public void print() {
        System.out.println("Hello World !");
    }
}
