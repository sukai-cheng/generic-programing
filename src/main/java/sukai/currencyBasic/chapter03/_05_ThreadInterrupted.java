package sukai.currencyBasic.chapter03;

import sukai.currencyBasic.caseV.SmallTool;

import java.util.concurrent.TimeUnit;

/**
 * @author chengsukai
 * @since 2022-08-18 10:27
 */
public class _05_ThreadInterrupted {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (true) {
                SmallTool.printTimeAndThread("walking");
                if (Thread.interrupted()) {
                    SmallTool.printTimeAndThread("sleep");
                }
            }
        });
        thread.setDaemon(true);
        thread.start();

        TimeUnit.MILLISECONDS.sleep(2);
        thread.interrupt();

    }
}
