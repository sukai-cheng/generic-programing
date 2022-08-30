package sukai.currencyadvance.chapter01;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.currentThread;
import static java.util.concurrent.ThreadLocalRandom.current;

/**
 * @author chengsukai
 * @since 2022-08-30 14:58
 */
public class TryLockExample {

    private final static Object VAL_OBJ = new Object();

    public static void main(String[] args) {
        final TryLock lock = new TryLock();
        final List<Object> validation = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (true) {
                    try {
                        if (lock.tryLock()) {
                            System.out.println(currentThread() + ":get the lock");
                            if (validation.size() > 1) {
                                throw new IllegalArgumentException("validation failed.");
                            }
                            validation.add(VAL_OBJ);
                            TimeUnit.MILLISECONDS.sleep(current().nextInt(10));
                        } else {
                            TimeUnit.MILLISECONDS.sleep(current().nextInt(10));
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        if (lock.release()) {
                            System.out.println(currentThread() + ": release the lock.");
                            validation.remove(VAL_OBJ);
                        }
                    }
                }
            }).start();
        }
    }
}
