package sukai.currency.chapter10;

import java.net.Socket;
import java.sql.Connection;

/**
 * @author chengsukai
 * @since 2022-08-25 13:47
 */
public class _03_Singleton {
    private byte[] data = new byte[1024];
    private volatile static _03_Singleton instance = null;
    Connection connection;
    Socket socket;

    private _03_Singleton() {
        this.connection = null;
        this.socket = null;
    }

    public static _03_Singleton getInstance() {
        if (null == instance) {
            synchronized (_03_Singleton.class) {
                if (null == instance) {
                    instance = new _03_Singleton();
                }
            }
        }
        return instance;
    }
}
