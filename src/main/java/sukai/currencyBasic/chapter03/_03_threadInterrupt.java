package sukai.currencyBasic.chapter03;

import java.util.concurrent.TimeUnit;

/**
 * @author chengsukai
 * @since 2022-08-18 09:34
 */
public class _03_threadInterrupt {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {

            try {
                TimeUnit.MINUTES.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("Oh, i am be interrupted");
            }

        });

        thread.start();

        TimeUnit.MILLISECONDS.sleep(2);
        thread.interrupt();
    }
}





