package sukai.currency.caseVIII;

import sukai.currency.caseV.SmallTool;

/**
 * @author chengsukai
 * @since 2022-08-16 15:47
 */
public class _03_interrupt {
    public static void main(String[] args) {
        Thread carOne = new Thread(() -> {
            long startMills = System.currentTimeMillis();
            while (System.currentTimeMillis() - startMills < 3) {
//                if (Thread.currentThread().isInterrupted()) {
                if (Thread.interrupted()) {
                    SmallTool.printTimeAndThread("向左开1米");
                } else {
                    SmallTool.printTimeAndThread("往前开1米");
                }
            }
        });
        carOne.start();

        SmallTool.sleepMills(1);
        carOne.interrupt();
    }
}
