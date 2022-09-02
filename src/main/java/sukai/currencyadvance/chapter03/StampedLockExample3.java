package sukai.currencyadvance.chapter03;

import java.util.concurrent.locks.StampedLock;

/**
 * @author chengsukai
 * @since 2022-09-02 09:28
 */
public class StampedLockExample3 {
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

    // 获取读锁，并且记录数据戳stamp
    public static int get() {
        // 获取一个乐观锁
        long stamp = lock.tryOptimisticRead();
        // 如果乐观锁无效则进入阻塞读
        if (!lock.validate(stamp)) {
            stamp = lock.readLock();
            try {
                return shareData;
            } finally {
                lock.unlockRead(stamp);
            }
        }

        // 有效则直接返回
        return shareData;
    }

}
