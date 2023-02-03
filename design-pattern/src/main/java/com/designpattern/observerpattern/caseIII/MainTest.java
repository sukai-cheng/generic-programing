package com.designpattern.observerpattern.caseIII;

public class MainTest {

    public static void main(String[] args) {

        // 创建主题对象
        ConcreteSubject subject = new ConcreteSubject();

        // 创建观察者对象
        ConcreteObserver observer = new ConcreteObserver();

        subject.attach(observer);

        subject.change("first state");

        subject.change("second state");

    }
}
