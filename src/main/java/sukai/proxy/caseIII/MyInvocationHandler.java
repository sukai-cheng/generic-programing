package sukai.proxy.caseIII;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author chengsukai
 * @since 2022-09-10 16:22
 */
public class MyInvocationHandler implements InvocationHandler {

    Object target; // 被代理对象

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("日志：调用了add方法，参数是" + Arrays.asList(args));

        Object result = method.invoke(target, args);

        System.out.println("日志：" + result);

        return null;
    }
}
