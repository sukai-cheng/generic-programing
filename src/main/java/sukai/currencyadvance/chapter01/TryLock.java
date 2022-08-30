package sukai.currencyadvance.chapter01;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author chengsukai
 * @since 2022-08-30 14:47
 */
public class TryLock {
    private final AtomicBoolean ab = new AtomicBoolean(false);
    private final ThreadLocal<Boolean> threadLocal = ThreadLocal.withInitial(() -> false);

    public boolean tryLock() {
        boolean result = ab.compareAndSet(false, true);
        if (result) {
            threadLocal.set(true);
        }
        return result;
    }
}
