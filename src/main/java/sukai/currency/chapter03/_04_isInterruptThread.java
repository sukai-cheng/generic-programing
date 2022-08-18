package sukai.currency.chapter03;

import java.util.concurrent.TimeUnit;


/**
 * @author chengsukai
 * @since 2022-08-18 09:40
 */
public class _04_isInterruptThread {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread() {
            @Override
            public void run() {
                while (true) {
                    // run方法中使用了sleep这个可中断方法，它会捕获到中断信号，并且会擦除interrupt标识
                    if (Thread.interrupted()) {
                        System.out.printf("I am be interrupted ? %s\n", isInterrupted());
                    }
                }
            }
        };
//        thread.setDaemon(true);
        thread.start();
        TimeUnit.MILLISECONDS.sleep(2);
//        System.out.printf("Thread is interrupted ? %s\n ", thread.isInterrupted());
        thread.interrupt();
//        TimeUnit.MILLISECONDS.sleep(2);
//        System.out.printf("Thread is interrupted ? %s\n ", thread.isInterrupted());
    }
}
