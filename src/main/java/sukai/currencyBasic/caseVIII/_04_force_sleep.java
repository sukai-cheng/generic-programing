package sukai.currencyBasic.caseVIII;

import sukai.currencyBasic.caseV.SmallTool;

import java.util.concurrent.TimeUnit;

/**
 * @author chengsukai
 * @since 2022-08-16 15:47
 */
public class _04_force_sleep {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            SmallTool.printTimeAndThread("开始睡眠");
            forceSleep(10);
            SmallTool.printTimeAndThread("结束睡眠");
        });
        thread.start();
        thread.interrupt();
    }

    public static void forceSleep(int second) {
        long startTime = System.currentTimeMillis();
        long sleepMills = TimeUnit.SECONDS.toMillis(second);

        while ((startTime + sleepMills) > System.currentTimeMillis()) {
            long sleepTime = startTime + sleepMills - System.currentTimeMillis();
            if (sleepTime <= 0) {
                break;
            }
            try {
//                抛出异常之前会清除线程的中断标识
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
//                SmallTool.printTimeAndThread("发生中断");
            }
        }
    }

}
