package sukai.currencyBasic.chapter18;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import static java.util.concurrent.ThreadLocalRandom.current;

/**
 * @author chengsukai
 * @since 2022-08-29 14:20
 */
public class Test {
    public static void main(String[] args) {
        final ProductionChannel channel = new ProductionChannel(5);
        AtomicInteger productionNo = new AtomicInteger();
        IntStream.range(1, 8).forEach(i -> {
            new Thread(() -> {
                while (true) {
                    channel.offerProduction(new Production(productionNo.getAndIncrement()));
                    try {
                        TimeUnit.SECONDS.sleep(current().nextInt(10));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        });

    }
}
