package sukai.currencyadvance.chapter06;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import static java.lang.Thread.currentThread;

/**
 * @author chengsukai
 * @since 2022-09-04 19:17
 */
public class InvokeAnyExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Callable<Integer>> callables = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            callables.add(() -> {
                int random = ThreadLocalRandom.current().nextInt(30);
                TimeUnit.SECONDS.sleep(random);
                System.out.println("Task: " + random + " completed in Thread " + currentThread());
                return random;
            });
        }
        Integer result = executorService.invokeAny(callables);
        System.out.println("Result: " + result);
    }
}
