package sukai.currencyadvance.chapter06;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author chengsukai
 * @since 2022-09-04 19:34
 */
public class CompletableFuture {
    public static void main(String[] args) {
        java.util.concurrent.CompletableFuture<Double> completableFuture = new java.util.concurrent.CompletableFuture<>();
        Executors.newCachedThreadPool().submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                completableFuture.complete(1245.23D);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        assert completableFuture.getNow(0.0D) == 0.0;
        try {
            assert completableFuture.get() == 1245.23D;
        }catch (InterruptedException | ExecutionException e){
            e.printStackTrace();
        }
    }
}
