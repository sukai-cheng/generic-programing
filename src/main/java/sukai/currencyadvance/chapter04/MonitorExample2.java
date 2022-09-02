package sukai.currencyadvance.chapter04;

import com.google.common.util.concurrent.RateLimiter;

import static java.lang.Thread.currentThread;

/**
 * @author chengsukai
 * @since 2022-09-02 10:32
 */
public class MonitorExample2 {

    // 定义一个Rate Limiter, 单位时间()
    private static RateLimiter rateLimiter = RateLimiter.create(0.5);

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(MonitorExample2::testRateLimiter).start();
        }
    }

    private static void testRateLimiter() {
        // 返回实际的等待开销时间
        double elapsedSecond = rateLimiter.acquire();
        System.out.println(currentThread() + ": elapsed seconds: " + elapsedSecond);
    }
}
