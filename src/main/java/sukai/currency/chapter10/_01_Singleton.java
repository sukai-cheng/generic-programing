package sukai.currency.chapter10;

/**
 * @author chengsukai
 * @since 2022-08-25 10:22
 */
public final class _01_Singleton {
    private byte[] data = new byte[32];
    private static _01_Singleton instance = new _01_Singleton();
    private _01_Singleton(){

    }

    public static _01_Singleton getInstance(){
        return instance;
    }

}
