package sukai.currencyBasic.chapter05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeoutException;

import static java.lang.System.currentTimeMillis;
import static java.lang.Thread.currentThread;

/**
 * @author chengsukai
 * @since 2022-08-22 12:19
 */
public class BooleanLock implements Lock {

    private Thread currentThread;

    private boolean locked = false;

    private final List<Thread> blockedList = new ArrayList<>();

    @Override
    public void lock() throws InterruptedException {
        synchronized (this) {
            while (locked) {
                final Thread tempThread = currentThread();
                try {
                    if (!blockedList.contains(currentThread)) {
                        blockedList.add(currentThread);
                    }
                    this.wait();// 这样就可以解决synchronized锁不可中断的弊端了
                } catch (InterruptedException e) {
                    blockedList.remove(tempThread);
                    throw e;
                }
            }
            blockedList.remove(currentThread);
            this.locked = true;
            this.currentThread = currentThread();
        }
    }

    @Override
    public void lock(long mills) throws InterruptedException, TimeoutException {
        synchronized (this) {
            if (mills < 0) {
                this.lock();
            } else {
                long remainingMills = mills;
                long endMills = currentTimeMillis() + remainingMills;
                while (locked) {
                    if (remainingMills <= 0) {
                        throw new TimeoutException("can not get the lock during " + mills);
                    }
                    if (!blockedList.contains(currentThread)) {
                        blockedList.add(currentThread);
                        this.wait(remainingMills);
                        remainingMills = endMills - currentTimeMillis();
                    }
                }
                blockedList.remove(currentThread);
                this.locked = true;
                // 获得锁的线程就是当前线程
                this.currentThread = currentThread();
            }
        }
    }

    @Override
    public void unlock() {
        // 只有加了锁的线程才有资格解锁
        synchronized (this) {
            if (currentThread == currentThread()) {
                this.locked = false;
                Optional.of(currentThread().getName() + " release the lock.").ifPresent(System.out::println);
                this.notifyAll();
            }
        }
    }

    @Override
    public List<Thread> getBlockedThreads() {
        return Collections.unmodifiableList(blockedList);
    }

}
