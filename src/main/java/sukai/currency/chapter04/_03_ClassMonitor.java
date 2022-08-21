package sukai.currency.chapter04;

import sukai.currency.caseV.SmallTool;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.currentThread;


/**
 * @author chengsukai
 * @since 2022-08-18 15:00
 */
public class _03_ClassMonitor {
    public static void main(String[] args) {
        new Thread(_03_ClassMonitor::method1).start();
        new Thread(_03_ClassMonitor::method2).start();
    }

    public static synchronized void method1() {
        SmallTool.printTimeAndThread(currentThread().getName() + " enter to method1");
        try {
            TimeUnit.MINUTES.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static synchronized void method2() {
        SmallTool.printTimeAndThread(currentThread().getName() + " enter to method2");
        try {
            TimeUnit.MINUTES.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
