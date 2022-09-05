package sukai.currencyadvance.chapter06;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author chengsukai
 * @since 2022-09-03 20:16
 */
public class FutureExample {
    public static void main(String[] args) {

        ExecutorService executor =
                Executors.newSingleThreadExecutor();
        Future<Double> future = executor.submit(() -> {
            throw new RuntimeException();
        });
        try {
            System.out.println("The task result: " + future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
