package sukai.currencyBasic.chapter03;

import sukai.currencyBasic.caseV.SmallTool;

/**
 * @author chengsukai
 * @since 2022-08-18 09:09
 */
public class _01_ThreadSleep {
    public static void main(String[] args) {
        new Thread(() -> {
            SmallTool.printTimeAndThread("我要休眠啦");
            long startTime = System.currentTimeMillis();
            SmallTool.sleepMills(2000);
            long endTime = System.currentTimeMillis();
            System.out.println(String.format("Total spend %d ms,", endTime - startTime));
        }).start();

        SmallTool.printTimeAndThread("我要休眠啦");
        long startTime = System.currentTimeMillis();
        SmallTool.sleepMills(3000);
        long endTime = System.currentTimeMillis();
        System.out.println(String.format("Main thread spend %d ms,", endTime - startTime));

    }
}
