package sukai.currency.chapter01;

import sukai.currency.caseV.SmallTool;

/**
 * @author chengsukai
 * @since 2022-08-17 15:40
 */
public class _01_TicketWindow_Thread extends Thread {
    private final String name;
    private static final int MAX = 50;

    // 使用static修饰， 做到了多线程下共享资源的唯一性，但是也存在线程安全问题
    private static int index = 1;

    public _01_TicketWindow_Thread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (index <= MAX) {
            SmallTool.printTimeAndThread("柜台： " + name + " 当前的号码是：" + (index++));
        }
    }

    public static void main(String[] args) {
        _01_TicketWindow_Thread a01TicketWindowThread1 = new _01_TicketWindow_Thread("一号出号机");
        _01_TicketWindow_Thread a01TicketWindowThread2 = new _01_TicketWindow_Thread("二号出号机");
        _01_TicketWindow_Thread a01TicketWindowThread3 = new _01_TicketWindow_Thread("三号出号机");
        _01_TicketWindow_Thread a01TicketWindowThread4 = new _01_TicketWindow_Thread("四号出号机");

        a01TicketWindowThread1.start();
        a01TicketWindowThread2.start();
        a01TicketWindowThread3.start();
        a01TicketWindowThread4.start();

    }
}
