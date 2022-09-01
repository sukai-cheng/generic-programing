package sukai.currencyadvance.chapter03;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.currentThread;

/**
 * @author chengsukai
 * @since 2022-09-01 11:08
 */
public class TryReentranLock {
    public static void main(String[] args) throws InterruptedException {
        final ReentrantLock lock = new ReentrantLock();
        new Thread(() -> {
            lock.lock();
            try {
                System.out.println(currentThread() + " acquired the lock111.");
                assert lock.getHoldCount() == 1;
                lock.lock(); // 重入
                assert lock.getHoldCount() == 2;
            } finally {
                lock.unlock();
                System.out.println(currentThread() + " released the lock111.");
                assert lock.getHoldCount() == 1;
            }
        }, "TT").start();

        TimeUnit.SECONDS.sleep(2);
        lock.lock();
        System.out.println(currentThread() + "acquired the lock.");
        lock.unlock();
        System.out.println(currentThread() + "release the lock.");
    }

}
