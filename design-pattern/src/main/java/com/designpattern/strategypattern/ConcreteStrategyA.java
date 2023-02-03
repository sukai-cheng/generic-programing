package com.designpattern.strategypattern;

public abstract class ConcreteStrategyA implements Strategy {

    public void printA(){
        System.out.println("I am strategy A");
    }
    @Override
    public void strategyInterface(){
        System.out.println("strategy A invoked");
    }

    /**
     * 子类也可重写接口定义的默认方法
     */
    @Override
    public void commonMethod() {
        System.out.println("modify parent default method");
    }
}
