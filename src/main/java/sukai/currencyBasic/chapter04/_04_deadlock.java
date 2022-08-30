package sukai.currencyBasic.chapter04;

import static java.lang.Thread.currentThread;

/**
 * @author chengsukai
 * @since 2022-08-21 23:42
 */
public class _04_deadlock {
    private final Object MUTEX_READ = new Object();
    private final Object MUTEX_WRITE = new Object();

    public void read() {
        synchronized (MUTEX_READ) {
            System.out.println(currentThread().getName() + " get READ lock");
            synchronized (MUTEX_WRITE) {
                System.out.println(currentThread().getName() + " get WRITE lock");
            }
            System.out.println(currentThread().getName() + " release WRITE lock");
        }
        System.out.println(currentThread().getName() + " release READ lock");
    }

    public void write() {
        synchronized (MUTEX_WRITE) {
            System.out.println(currentThread().getName() + " get WRITE lock");
            synchronized (MUTEX_READ) {
                System.out.println(currentThread().getName() + " get READ lock");
            }
            System.out.println(currentThread().getName() + " release READ lock");
        }
        System.out.println(currentThread().getName() + " release WRITE lock");
    }

    public static void main(String[] args) {
        final _04_deadlock deadlock = new _04_deadlock();
        new Thread(() -> {
            while (true) {
                deadlock.read();
            }
        }, "READ-LOCK").start();

        new Thread(() -> {
            while (true) {
                deadlock.write();
            }
        }, "WRITE-LOCK").start();
    }
}
