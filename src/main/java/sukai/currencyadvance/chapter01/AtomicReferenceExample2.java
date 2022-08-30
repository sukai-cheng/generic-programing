package sukai.currencyadvance.chapter01;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

import static java.util.concurrent.ThreadLocalRandom.current;

/**
 * @author chengsukai
 * @since 2022-08-30 15:11
 */
public class AtomicReferenceExample2 {
    // 创造AtomicReference对象并且赋初始值
    private static AtomicReference<DebitCard> debitCardRef = new AtomicReference<>(new DebitCard("Alex", 0));

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread("T-" + i) {
                @Override
                public void run() {
                    while (true) {

                        final DebitCard dc = debitCardRef.get();
                        DebitCard newDc = new DebitCard(dc.getAccount(), dc.getAmount() + 10);
                        // 基于CAS操作，可以实现非阻塞
                        // CAS是乐观锁，并且自旋
                        if (debitCardRef.compareAndSet(dc, newDc)) {
                            System.out.println(newDc);
                        }
                        try {
                            TimeUnit.MILLISECONDS.sleep(current().nextInt(20));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }.start();
        }
    }
}
