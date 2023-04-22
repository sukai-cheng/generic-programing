package com.designpattern.proxypattern.caseIV;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author chengsukai
 */
public class ProxyAlipayTransaction implements InvocationHandler {

    private Transaction target;

    public Object getInstance(Transaction target) throws Exception {
        this.target = target;

        Class<? extends Transaction> clazz = target.getClass();
        System.out.println("ProxyAlipayTransaction获取的被代理对象是:" + clazz);

        // 生成代理对象
        Object obj = Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);

        return obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("支付之前, 记录订单信息");

        System.out.println("-------------start---------------");
        Object result = method.invoke(this.target, args);
        System.out.println("-------------end---------------");

        System.out.println("支付之后,调用发票服务开发票");

        return result;
    }
}













