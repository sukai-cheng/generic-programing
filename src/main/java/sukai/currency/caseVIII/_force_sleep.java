package sukai.currency.caseVIII;

import sukai.currency.caseV.SmallTool;

/**
 * @author chengsukai
 * @since 2022-08-16 16:52
 */
public class _force_sleep {
    public static void main(String[] args) {
        forceSlepp(5000);
    }

    private static void forceSlepp(long time) {
        if (time == 0) {
            SmallTool.printTimeAndThread("结束睡眠");
        }

        long t0 = System.currentTimeMillis();
        SmallTool.printTimeAndThread("开始睡眠");
        try {
            Thread.interrupted();
            Thread.sleep(time);
            SmallTool.printTimeAndThread("结束睡眠");
        } catch (InterruptedException e) {
            long t1 = System.currentTimeMillis();

            forceSlepp(time - (t1 - t0));
        }
    }
}
