package sukai.currencyBasic.chapter06;

import java.util.concurrent.TimeUnit;

/**
 * @author chengsukai
 * @since 2022-08-23 16:15
 */
public class _02_ThreadGroupEnumerateThreads {
    public static void main(String[] args) throws InterruptedException {
        ThreadGroup myGroup = new ThreadGroup("MyGroup");
        Thread thread = new Thread(myGroup, () -> {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {

                }
            }
        }, "MyThread");

        thread.start();

        TimeUnit.MILLISECONDS.sleep(2);
        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup(); // 默认为main的主线程

        Thread[] list = new Thread[mainGroup.activeCount()];
        int recurseSize = mainGroup.enumerate(list);
        System.out.println(recurseSize);

        recurseSize = mainGroup.enumerate(list, false);
        System.out.println(recurseSize);
    }
}
