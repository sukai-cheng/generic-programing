package sukai.currency.chapter10;

/**
 * @author chengsukai
 * @since 2022-08-25 14:14
 */
public enum _05_Singleton {

    // 枚举类是线程安全的且只能被实例化一次
    INSTANCE;

    private byte[] data = new byte[1024];

    _05_Singleton() {
        System.out.println("INSTANCE will be initialized immediately");
    }

    public static void method() {

    }

    public static _05_Singleton getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        _05_Singleton.method();
    }
}
