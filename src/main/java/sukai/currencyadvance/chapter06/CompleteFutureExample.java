package sukai.currencyadvance.chapter06;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

/**
 * @author chengsukai
 * @since 2022-09-04 19:45
 */
public class CompleteFutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> 353, Executors.newCachedThreadPool());

        assert future.get() == 353;
    }
}
