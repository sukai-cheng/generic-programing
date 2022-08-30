package sukai.currencyBasic.caseVIII;

import sukai.currencyBasic.caseV.SmallTool;

import java.util.Random;

/**
 * @author chengsukai
 * @since 2022-08-16 15:37
 */
public class _TwoCarCrossBridge {
    public static void main(String[] args) {
        Thread carTwo = new Thread(() -> {
            SmallTool.printTimeAndThread("卡丁2号 准备过桥");
            SmallTool.printTimeAndThread("发现1号在过，开始等待");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                SmallTool.printTimeAndThread("卡丁2号 开始过桥");
            }
            SmallTool.printTimeAndThread("卡丁二号 过桥完毕");
        });

        Thread carOne = new Thread(() -> {
            SmallTool.printTimeAndThread("卡丁1号 准备过桥");
            int timeSpend = new Random().nextInt(500) + 1000;
            SmallTool.sleepMills(timeSpend);
            SmallTool.printTimeAndThread("卡丁1号 过桥完毕，耗时：" + timeSpend);

            // 卡丁1号 中断了 卡丁2号
            carTwo.interrupt();
        });

        carOne.start();
        carTwo.start();
    }
}
