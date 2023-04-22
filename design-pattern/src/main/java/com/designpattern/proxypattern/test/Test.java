package com.designpattern.proxypattern.test;

/**
 * @author chengsukai
 */
public class Test {

    public static void main(String[] args) {
        PersonProxyHandler personProxyHandler = new PersonProxyHandler();

        Person instance = (Person)personProxyHandler.getInstance(new Man());

        instance.doLove();


    }
}
