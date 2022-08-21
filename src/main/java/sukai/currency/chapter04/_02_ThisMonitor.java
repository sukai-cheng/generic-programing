package sukai.currency.chapter04;

import sukai.currency.caseV.SmallTool;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.currentThread;

/**
 * @author chengsukai
 * @since 2022-08-18 14:43
 */
public class _02_ThisMonitor {
    public static void main(String[] args) {
        _02_ThisMonitor thisMonitor = new _02_ThisMonitor();
        new Thread(thisMonitor::method1, "T1").start();
        new Thread(thisMonitor::method2, "T2").start();

    }

    public synchronized void method1() {
        SmallTool.printTimeAndThread(currentThread().getName() + " enter to method1");
        try {
            TimeUnit.MINUTES.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public synchronized void method2() {
        SmallTool.printTimeAndThread(currentThread().getName() + " enter to method2");
        try {
            TimeUnit.MINUTES.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
