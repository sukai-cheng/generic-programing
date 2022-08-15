package sukai.currency.caseIII;

import cn.hutool.core.lang.func.Func;
import com.google.common.util.concurrent.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * completableFuture由Java 8提供，实现异步化的工具，解决了 回调地狱 的问题
 *
 * @author chengsukai
 * @since 2022-08-10 09:38
 */
public class CompletableFutureTest {
    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newFixedThreadPool(5); // define thread pool, capacity = 5
//        ListeningExecutorService guavaExecutor = MoreExecutors.listeningDecorator(executorService);
//        ListenableFuture<String> future1 = guavaExecutor.submit(() -> {
//            System.out.println("执行 step 1");
//            return "step1 result";
//        });
//        ListenableFuture<String> future2 = guavaExecutor.submit(() -> {
//            System.out.println("执行 stop 2");
//            return "step2 result";
//        });
//        ListenableFuture<List<String>> future1And2 = Futures.allAsList(future1, future2);
//        Futures.addCallback(future1And2, new FutureCallback<>() {
//            @Override
//            public void onSuccess(List<String> result) {
//                System.out.println(result);
//                // 如果成功，则执行step3
//                ListenableFuture<String> future3 = guavaExecutor.submit(() -> {
//                    System.out.println("执行step 3");
//                    return "step3 result";
//                });
//                // 如果step3成功， 返回callback
//                Futures.addCallback(future3, new FutureCallback<String>() {
//                    @Override
//                    public void onSuccess(String result) {
//                        System.out.println(result);
//                    }
//
//                    @Override
//                    public void onFailure(Throwable t) {
//                    }
//                }, guavaExecutor);
//            }
//
//            @Override
//            public void onFailure(Throwable t) {
//            }
//        }, guavaExecutor);


        ExecutorService executorService = Executors.newFixedThreadPool(5);

        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("执行step1");
            return "step1 result";
        },executorService);

        CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("执行 step2");
            return "step2 result";
        },executorService);

        cf1.thenCombine(cf2,(res1, res2)->{
            System.out.println(res1 +" ---- " + res2);
            System.out.println("execute step3");
            return "step3 result";
        }).thenAccept(System.out::println);

    }

}






























