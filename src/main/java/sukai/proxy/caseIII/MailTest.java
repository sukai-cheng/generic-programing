package sukai.proxy.caseIII;


import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author chengsukai
 * @since 2022-09-10 16:04
 */
public class MailTest {

    @Test
    public void test() {

        Calculator calculator = new Calculator();
        ICalculator proxy = (ICalculator)createProxy(calculator);
        System.out.println(proxy.div(1, 1));
    }

    public static Object createProxy(Object needProxy){
        ClassLoader classLoader = needProxy.getClass().getClassLoader();
        Class<?>[] interfaces = needProxy.getClass().getInterfaces();
        InvocationHandler handler = new MyInvocationHandler(needProxy);

        Object o = Proxy.newProxyInstance(classLoader, interfaces, handler);
        System.out.println(o.getClass());

        return o;
    }














}
