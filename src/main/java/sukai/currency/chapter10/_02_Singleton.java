package sukai.currency.chapter10;

/**
 * @author chengsukai
 * @since 2022-08-25 13:16
 */
public final class _02_Singleton {
    private byte[] data = new byte[1024];
    private static _02_Singleton instance = null;

    private _02_Singleton() {
    }

    // 加了synchronized后导致该方法同一时刻只能有一个线程能访问
    public static synchronized _02_Singleton getInstance() {
        // 多线程情况下会导致 instance 会被实例化多次
        if (null == instance) instance = new _02_Singleton();
        return instance;
    }
}
