package sukai.currencyadvance.chapter06;

import java.util.concurrent.*;

/**
 * @author chengsukai
 * @since 2022-09-03 11:15
 */
public class ThreadPoolExecutor {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        java.util.concurrent.ThreadPoolExecutor executor = new java.util.concurrent.ThreadPoolExecutor(2,4,30, TimeUnit.SECONDS,new ArrayBlockingQueue<>(10), Executors.defaultThreadFactory(),new java.util.concurrent.ThreadPoolExecutor.DiscardPolicy());
        executor.execute(() -> System.out.println("executor the runnable task"));
        Future<String> future = executor.submit(() -> "Execute the callable task and this is the result");
        System.out.println(future.get());


    }
}
