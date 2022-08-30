package sukai.currencyBasic.chapter13;

/**
 * @author chengsukai
 * @since 2022-08-26 15:51
 */
public interface Lock {
    void lock() throws InterruptedException;

    void unlock();
}
