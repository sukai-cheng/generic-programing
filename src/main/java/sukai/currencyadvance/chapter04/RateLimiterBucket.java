package sukai.currencyadvance.chapter04;

import com.google.common.util.concurrent.Monitor;
import com.google.common.util.concurrent.RateLimiter;
import lombok.Data;
import sukai.functional.lambda.caseIII.Consumer;

import java.util.concurrent.ConcurrentLinkedQueue;

import static java.lang.Thread.currentThread;

/**
 * @author chengsukai
 * @since 2022-09-02 13:17
 */
@Data
public class RateLimiterBucket {
    @Data
    static class Request {
        private final int data;

        public Request(int data) {
            this.data = data;
        }

    }

    private final ConcurrentLinkedQueue<Request> bucket =
            new ConcurrentLinkedQueue<>();

    private final static int BUCKET_CPAACITY = 1000;

    private final RateLimiter rateLimiter = RateLimiter.create(10.0D);

    private final Monitor requestMonitor = new Monitor();

    private final Monitor handleMonitor = new Monitor();

    public void submitRequest(int data) {
        this.submitRequest(new Request(data));
    }

    public void submitRequest(Request request) {
        if (requestMonitor.enterIf(requestMonitor.newGuard(
                        () -> bucket.size() < BUCKET_CPAACITY
                )
        )) {
            try {
                boolean result = bucket.offer(request);
                if (result) {
                    System.out.println(currentThread() + "submit request: " + request.getData() + " successfully.");
                } else {
                    // produce into MQ and will try again later.
                }
            } finally {
                requestMonitor.leave();
            }
        } else {
            System.out.println("The request:" + request.getData() + " will be down-dimensional handle due to bucket is overflow.");
            // produce into MQ and will try again later.
        }
    }

    public void handleRequest(Consumer<Request> consumer) {
        if (handleMonitor.enterIf(handleMonitor.newGuard(
                () -> !bucket.isEmpty()
        ))) {
            try {
                // 匀速处理
                rateLimiter.acquire();
                // 处理数据
                consumer.accept(bucket.poll());
            } finally {
                handleMonitor.leave();
            }
        }
    }

}
