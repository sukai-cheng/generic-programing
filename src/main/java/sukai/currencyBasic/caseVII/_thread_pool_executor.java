package sukai.currencyBasic.caseVII;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author chengsukai
 * @since 2022-08-16 12:01
 */
public class _thread_pool_executor {
    public static void main(String[] args) {
//        Executors.newSingleThreadExecutor();
//        Executors.newCachedThreadPool();
        ExecutorService executorService = Executors.newFixedThreadPool(3);

    }
}
