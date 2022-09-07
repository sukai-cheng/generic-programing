package sukai.currencyadvance.chapter06;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author chengsukai
 * @since 2022-09-05 21:33
 */
public class MultiFutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> "Java");
        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> "Parallel");
        CompletableFuture<String> f3 = CompletableFuture.supplyAsync(() -> "Future");

        CompletableFuture<Void> future = CompletableFuture.allOf(f1, f2, f3).thenRun(() -> {
            try {
                System.out.println(f1.isDone() + " and result: " + f1.get());
                System.out.println(f1.isDone() + " and result: " + f2.get());
                System.out.println(f1.isDone() + " and result: " + f3.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });

        future.get();

    }
}
