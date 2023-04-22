package com.designpattern.proxypattern.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author chengsukai
 */
public class PersonProxyHandler implements InvocationHandler {

    private Person person;

    public Object getInstance(Person person) {
        this.person = person;

        Class<? extends Person> clazz = person.getClass();

        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("-------------start---------------");
        Object obj = method.invoke(this.person, args);
        System.out.println("-------------end---------------");
        return obj;
    }
}
