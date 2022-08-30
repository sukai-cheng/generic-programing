package sukai.currencyadvance.chapter01;

import java.util.concurrent.TimeUnit;

import static java.util.concurrent.ThreadLocalRandom.current;

/**
 * @author chengsukai
 * @since 2022-08-30 15:11
 */
public class AtomicReferenceExample1 {
    static volatile DebitCard debitCard = new DebitCard("Alex", 0);

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread("T-" + i) {
                @Override
                public void run() {
                    while (true) {
                        synchronized (AtomicReferenceExample1.class) {
                            final DebitCard dc = debitCard;
                            DebitCard newDc = new DebitCard(dc.getAccount(), dc.getAmount() + 10);
                            System.out.println(newDc);
                            debitCard = newDc;
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
