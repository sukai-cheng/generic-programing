package sukai.desginpattern.onebeanpattern;

/**
 * 双重检查单例模式
 * @author chengsukai
 * @since 2022-11-18 13:21
 */
public class Singleton {
    private volatile static Singleton INSTANCE;

    private Singleton() {

    }

    public static Singleton getInstance() {
        if (INSTANCE == null) {
            synchronized (Singleton.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Singleton();
                }
            }
        }
        return INSTANCE;
    }

}


