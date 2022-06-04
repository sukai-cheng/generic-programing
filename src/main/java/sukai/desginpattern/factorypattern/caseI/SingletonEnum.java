package sukai.desginpattern.factorypattern.caseI;

/**
 * 使用枚举实现单例模式
 */
public enum SingletonEnum {

    singletonFactory;

    private final MySingleton instance;

    SingletonEnum() {
        instance = new MySingleton();
    }

    public MySingleton getInstance() {
        return instance;
    }
}


class MySingleton {
    public MySingleton() {
    }
}