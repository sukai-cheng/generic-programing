package sukai.currencyBasic.chapter05;

import java.util.concurrent.TimeUnit;

/**
 * @author chengsukai
 * @since 2022-08-22 09:21
 */
public class _01_EventClient {
    public static void main(String[] args) {
        final _01_EventQueue eventQueue = new _01_EventQueue();
        new Thread(() -> {
            for (; ; ) {
                eventQueue.offer(new _01_EventQueue.Event());
            }
        }, "producer").start();

        new Thread(() -> {
            for (; ; ) {
                eventQueue.take();
                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "consumer").start();
    }
}
