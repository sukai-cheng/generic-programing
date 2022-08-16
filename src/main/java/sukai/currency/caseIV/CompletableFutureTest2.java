package sukai.currency.caseIV;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * completableFuture由Java 8提供，实现异步化的工具，解决了 回调地狱 的问题
 *
 * @author chengsukai
 * @since 2022-08-10 09:38
 */
public class CompletableFutureTest2 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        //1、使用runAsync或supplyAsync发起异步调用
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> "result1", executor);


    }
}






























