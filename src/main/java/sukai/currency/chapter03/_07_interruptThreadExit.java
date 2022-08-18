package sukai.currency.chapter03;

import sukai.currency.caseV.SmallTool;

import java.util.concurrent.TimeUnit;

/**
 * @author chengsukai
 * @since 2022-08-18 12:49
 */
public class _07_interruptThreadExit {
    public static void main(String[] args) throws InterruptedException {

        Thread t = new Thread() {
            @Override
            public void run() {

                SmallTool.printTimeAndThread("I will start work");
                // 检查线程中断标识来决定是否退出的
                while (!isInterrupted()) {
                    SmallTool.printTimeAndThread("Working");
                }
                SmallTool.printTimeAndThread("I will be exiting");

            }
        };

        t.start();
        // let t started
        TimeUnit.SECONDS.sleep(1);
        SmallTool.printTimeAndThread("System will be shutdown");
        t.interrupt();
    }
}
