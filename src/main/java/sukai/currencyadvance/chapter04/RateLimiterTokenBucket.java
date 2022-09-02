package sukai.currencyadvance.chapter04;

import com.google.common.util.concurrent.Monitor;
import com.google.common.util.concurrent.RateLimiter;
import sukai.functional.lambda.caseII.Consumer;

import java.util.concurrent.TimeUnit;

/**
 * @author chengsukai
 * @since 2022-09-02 13:52
 */
public class RateLimiterTokenBucket {
    private final static int MAX = 1000;
    private int orderID;
    private final RateLimiter rateLimiter = RateLimiter.create(10.0D);
    private Monitor bookOrderMonitor = new Monitor();

    static class NoProductionException extends Exception {
        public NoProductionException(String message) {
            super(message);
        }
    }

    static class OrderFailedException extends Exception {
        public OrderFailedException(String message) {
            super(message);
        }
    }

    public void bookOrder(Consumer<Integer> consumer) throws NoProductionException, OrderFailedException {
        // 对象锁或者condition时的临界值判断
        if (bookOrderMonitor.enterIf(bookOrderMonitor.newGuard(
                () -> orderID < MAX
        ))) {
            try {
                // 尝试获取令牌最多等待100毫秒
                if (!rateLimiter.tryAcquire(100, TimeUnit.MILLISECONDS)) {
                    throw new OrderFailedException("book order failed, please try again later.");
                }
                orderID++;
                consumer.accept(orderID);
            } finally {
                bookOrderMonitor.leave();
            }
        } else {
            throw new NoProductionException("No available production now.");
        }
    }

}
