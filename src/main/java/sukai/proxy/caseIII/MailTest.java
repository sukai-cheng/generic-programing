package sukai.proxy.caseIII;


import org.junit.Test;

import java.lang.reflect.Proxy;

/**
 * @author chengsukai
 * @since 2022-09-10 16:04
 */
public class MailTest {

    @Test
    public void test() {

        // 获取classLoader
        ClassLoader classLoader = ICalculator.class.getClassLoader();

        // 获取类的接口
        Class<?>[] interfaces = new Class[]{ICalculator.class};

        // 获取代理类
        MyInvocationHandler handler = new MyInvocationHandler(new Calculator());

        // 得到的代理类
        ICalculator o = (ICalculator) Proxy.newProxyInstance(classLoader, interfaces, handler);

        System.out.println(o.getClass());
        System.out.println(o.mul(1, 1));

    }
}
