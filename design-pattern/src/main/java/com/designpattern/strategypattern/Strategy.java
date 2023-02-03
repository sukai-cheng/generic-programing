package com.designpattern.strategypattern;

public interface Strategy {

    /**
     * 可以在接口中定义默认方法
     */
    default void commonMethod(){
        System.out.println("This is a common method");
    }
    void strategyInterface();
}
