package sukai.currencyadvance.chapter06;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.*;

import static java.lang.Thread.currentThread;

/**
 * @author chengsukai
 * @since 2022-09-03 19:15
 */
public class ThreadPoolClosed {
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 4, 30,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy()
        );
        // 提交10个任务
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println(currentThread() + " is running.");
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        executor.shutdown();
        executor.execute(() -> System.out.println("new task submit after shutdown"));

        executor.awaitTermination(10, TimeUnit.MINUTES);
        assert executor.isShutdown();
        assert executor.isTerminated();
        assert executor.isTerminated();
    }

    void shutdownAndAwaitTermination(ExecutorService executor,
                                     long timeout,
                                     TimeUnit timeUnit) {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(timeout, timeUnit)){
                executor.shutdownNow();
                if (!executor.awaitTermination(timeout, timeUnit)) {
                    // print executor not terminated by normal
                }
            }

        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }

}


























