package sukai.desginpattern.factorypattern.caseI;

/**
 * 双重检测机制
 */
public class SingletonDsl {
    private static volatile SingletonDsl singletonDsl;

    private SingletonDsl() {
    }

    public static SingletonDsl getInstance() {
        if (singletonDsl == null) {
            synchronized ((SingletonDsl.class)) {
                if (singletonDsl == null) {
                    singletonDsl = new SingletonDsl();
                }
            }
        }
        return singletonDsl;
    }
}
