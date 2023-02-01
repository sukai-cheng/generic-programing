package com.designpattern.decoratorpattern.caseI;

/**
 * @author chengsukai
 **/
public class Client {
    public static void main(String[] args) {
        ConcreteComponent component = new ConcreteComponent();
        ConcreteDecoratorA concreteDecoratorA = new ConcreteDecoratorA();
        ConcreteDecoratorB concreteDecoratorB = new ConcreteDecoratorB();

        concreteDecoratorA.setComponent(component);
        concreteDecoratorB.setComponent(concreteDecoratorA);
        concreteDecoratorB.Operation();
    }
}