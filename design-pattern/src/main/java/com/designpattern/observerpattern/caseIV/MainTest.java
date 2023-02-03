package com.designpattern.observerpattern.caseIV;

public class MainTest {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();

        ConcreteObserver observer = new ConcreteObserver();

        subject.attach(observer);

        subject.change("this is the first change");

        subject.change("this is the second change");


    }
}
