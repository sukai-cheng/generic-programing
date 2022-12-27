package sukai.bestjavapractice;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author chengsukai
 * @since 2022-12-27 13:21
 */
public class ByCallable {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("main线程：" + Thread.currentThread().getName());
        Callable<String> callable = new MyCallable();
        FutureTask <String> futureTask = new FutureTask<>(callable);
        new Thread(futureTask).start();
        System.out.println("MyCallable的执行线程：" + futureTask.get());
    }
    static class MyCallable implements Callable{

        @Override
        public Object call() throws Exception {
            System.out.println("MyCallable的线程: " + Thread.currentThread().getName());
            return Thread.currentThread().getName();
        }
    }
}


