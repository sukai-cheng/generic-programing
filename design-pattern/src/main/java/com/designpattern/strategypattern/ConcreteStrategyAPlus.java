package com.designpattern.strategypattern;

public class ConcreteStrategyAPlus extends ConcreteStrategyA{

    public static void main(String[] args) {
        ConcreteStrategyAPlus concreteStrategyAPlus = new ConcreteStrategyAPlus();
        concreteStrategyAPlus.printA();
        concreteStrategyAPlus.commonMethod();
    }
}
