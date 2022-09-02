package sukai.currencyadvance.chapter03;

import java.util.concurrent.locks.StampedLock;

/**
 * @author chengsukai
 * @since 2022-09-02 09:28
 */
public class StampedLockExample1 {
    private static int shareData = 0;
    private static final StampedLock lock = new StampedLock();

    public static void inc() {
        long stamp = lock.writeLock();
        try {
            shareData++;
        } finally {
            lock.unlockWrite(stamp);
        }
    }

    public static int get() {
        long stamp = lock.writeLock();
        try {
            return shareData;
        } finally {
            lock.unlockWrite(stamp); //锁释放需要用到时间戳
        }
    }
}
