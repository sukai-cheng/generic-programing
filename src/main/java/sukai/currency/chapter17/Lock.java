package sukai.currency.chapter17;

/**
 * @author chengsukai
 * @since 2022-08-26 15:51
 */
public interface Lock {
    void lock() throws InterruptedException;

    void unlock();
}
