package sukai.currencyadvance.chapter06;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author chengsukai
 * @since 2022-09-03 13:28
 */
public class MyThreadFactory implements ThreadFactory {
    private final static String PREFIX = "ALEX";
    private final static AtomicInteger INC = new AtomicInteger();

    @Override
    public Thread newThread(@NotNull Runnable r) {
        ThreadGroup threadGroup = new ThreadGroup("MyPool");
        Thread thread = new Thread(threadGroup, r, PREFIX + " - " + INC.getAndIncrement());
        thread.setPriority(10);
        return thread;
    }
}
