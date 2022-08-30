package sukai.currencyBasic.chapter05;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static java.lang.Thread.currentThread;
import static java.util.concurrent.ThreadLocalRandom.current;

/**
 * @author chengsukai
 * @since 2022-08-22 13:24
 */
public class _03_BooleanLockTest {
    private final Lock lock = new BooleanLock();

    public void syncMethod() {
        try {
            lock.lock();
            int randomInt = current().nextInt(10);
            System.out.println(currentThread() + " get the lock.");
            TimeUnit.SECONDS.sleep(randomInt);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void syncMethodTimeoutable() {
        try {
            lock.lock(1000);
            System.out.println(currentThread() + " get the lock.");
            int randomInt = current().nextInt(10);
            TimeUnit.SECONDS.sleep(randomInt);
        } catch (InterruptedException | TimeoutException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        _03_BooleanLockTest blt = new _03_BooleanLockTest();
        new Thread(blt::syncMethod, "T1").start();
        TimeUnit.MILLISECONDS.sleep(2);
        Thread t2 = new Thread(blt::syncMethodTimeoutable, "T2");
        t2.start();
        TimeUnit.MILLISECONDS.sleep(10);
    }
}
