package sukai.currency.chapter19;

import sukai.currency.chapter11.Task;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author chengsukai
 * @since 2022-08-29 15:21
 */
public class FutureServiceImpl<IN, OUT> implements FutureService<IN, OUT> {
    private final static String FUTURE_THREAD_PREFIX = "FUTURE--";
    private final AtomicInteger nextCounter = new AtomicInteger(0);

    private String getNextName() {
        return FUTURE_THREAD_PREFIX + nextCounter.getAndIncrement();
    }

    @Override
    public Future<?> submit(Runnable runnable) {
        final FutureTask<Void> future = new FutureTask<>();
        new Thread(() -> {
            runnable.run();
            future.finish(null);
        }, getNextName()).start();

        return future;
    }

    @Override
    public Future<OUT> submit(Task<IN, OUT> task, IN input) {
        // 分别启动了新的线程运行任务，起到了异步的作用
        final FutureTask<OUT> future = new FutureTask<>();
        new Thread(() -> {
            OUT result = task.get(input);
            future.finish(result);
        }, getNextName()).start();
        return future;
    }
}































