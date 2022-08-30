package sukai.currencyBasic.chapter05;

import java.util.List;
import java.util.concurrent.TimeoutException;

/**
 * @author chengsukai
 * @since 2022-08-22 12:18
 */
public interface Lock {
    void lock() throws InterruptedException;
    void lock(long mills) throws InterruptedException, TimeoutException;
    void unlock();
    List<Thread> getBlockedThreads();
}
