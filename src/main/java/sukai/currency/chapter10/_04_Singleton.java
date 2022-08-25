package sukai.currency.chapter10;

/**
 * @author chengsukai
 * @since 2022-08-25 13:58
 */
public final class _04_Singleton {
    private byte[] data = new byte[1024];
    private static _04_Singleton instance = null;

    private _04_Singleton() {
        // 防止反射入侵外部类
        if (Holder.singleton == null) {
            throw new IllegalStateException();
        }
    }

    // 静态内部类中持有Singleton的实例
    // 同步方法可以保证内存的可见性，JVM指令的顺序性和原子性
    // 静态内部类始终只会加载一次从而能保证单例
    // 实现饿汉式
    private static class Holder {
        private static _04_Singleton singleton = new _04_Singleton();
    }

    public static _04_Singleton getInstance() {
        if (null == instance) {
            instance = Holder.singleton;
        }
        return instance;
    }
}
