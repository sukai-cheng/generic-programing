package sukai.currencyadvance.chapter04;

import com.google.common.util.concurrent.RateLimiter;

/**
 * @author chengsukai
 * @since 2022-09-02 10:32
 */
public class MonitorExample3 {

    // 定义一个Rate Limiter, 单位时间()或者令牌为2
    private static RateLimiter rateLimiter = RateLimiter.create(2);

    public static void main(String[] args) {
        System.out.println(rateLimiter.acquire(4));
        System.out.println(rateLimiter.acquire(2));
        System.out.println(rateLimiter.acquire(2));
        System.out.println(rateLimiter.acquire(2));
    }
}
