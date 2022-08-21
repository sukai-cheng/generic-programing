package sukai.currency.chapter04;

import sukai.currency.caseV.SmallTool;

/**
 * @author chengsukai
 * @since 2022-08-17 15:40
 */
public class _01_TicketWindow_Runnable implements Runnable {
    private static final int MAX = 150;

    // 多个线程共享同一个Runnable
    // 多个线程同时操作共享变量引发线程安全问题
    private int index = 1;

    private final Object MUTEX = new Object();

    @Override
    public void run() {
        synchronized (MUTEX) {
            while (index <= MAX) {
                SmallTool.printTimeAndThread("柜台： " + " 当前的号码是：" + (index++));
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        final _01_TicketWindow_Runnable task = new _01_TicketWindow_Runnable();
        Thread windowThread1 = new Thread(task, "一号出号机");
        Thread windowThread2 = new Thread(task, "二号出号机");
        Thread windowThread3 = new Thread(task, "三号出号机");
        Thread windowThread4 = new Thread(task, "四号出号机");

        windowThread1.start();
        windowThread2.start();
        windowThread3.start();
        windowThread4.start();
    }
}
