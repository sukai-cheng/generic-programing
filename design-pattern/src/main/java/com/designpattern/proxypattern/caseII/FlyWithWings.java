package com.designpattern.proxypattern.caseII;

/**
 * @description
 *
 * @author chengsukai
 *
 * @create 2022-05-05 13:33
 **/
public class FlyWithWings implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("Duck can flying by wings");
    }
}