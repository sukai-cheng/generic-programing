package sukai.currencyBasic.chapter12;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author chengsukai
 * @since 2022-08-27 19:01
 */
@Slf4j
public class SemaPhoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(5);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire(); // 线程通过acquire方法获取一个信号量，如果没有获取到就进入wait set中
                    log.info("成功获取令牌");
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    log.info("释放令牌");
                    semaphore.release(); // 线程通过release方法释放一个信号量，信号量加一，此时notifyAll所有因为没有获得到令牌而block的进程
                }
            });
        }
        executorService.shutdown();
    }
}
