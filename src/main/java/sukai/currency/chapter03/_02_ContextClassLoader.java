package sukai.currency.chapter03;

/**
 * @author chengsukai
 * @since 2022-08-18 09:29
 */
public class _02_ContextClassLoader {

    public static void main(String[] args) {

        Thread thread = new Thread();
        thread.getContextClassLoader();//获取线程上下文的类加载器
        thread.setContextClassLoader(thread.getContextClassLoader()); // 设置该线程的类加载器,可以打破类加载的父委托机制
    }
}

