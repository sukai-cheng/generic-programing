package com.concurrencybasic.aqslock;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * 实现自定义的同步工具类
 */
public class LeeLock {

    private static class Sync extends AbstractQueuedSynchronizer {

        /**
         * 独占式的获取锁，返回值是boolean类型的，true代表获取锁，false代表获取失败。
         */
        @Override
        protected boolean tryAcquire(int arg) {
            return compareAndSetState(0, 1);
        }

        @Override
        protected boolean tryRelease(int arg) {
            setState(0);
            return true;
        }

        @Override
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }
    }
    private Sync sync = new Sync();

    public void lock() {
        sync.acquire(1);
    }

    public void unlock() {
        sync.release(1);
    }

}
