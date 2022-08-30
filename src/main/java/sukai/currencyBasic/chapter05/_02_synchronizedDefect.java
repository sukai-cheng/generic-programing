package sukai.currencyBasic.chapter05;

import java.util.concurrent.TimeUnit;

/**
 * @author chengsukai
 * @since 2022-08-22 12:08
 */
public class _02_synchronizedDefect {
    public synchronized void syncMethod() {
        try {
            TimeUnit.HOURS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        _02_synchronizedDefect defect = new _02_synchronizedDefect();
        Thread t1 = new Thread(defect::syncMethod, "T1");
        t1.start();

        TimeUnit.MILLISECONDS.sleep(2);

        Thread t2 = new Thread(defect::syncMethod, "T2");
        t2.start();

        TimeUnit.MILLISECONDS.sleep(2);

        t2.interrupt();

        // 被synchronized同步的线程不可被中断而sleep和wait是可以被中断的
        System.out.println(t2.isInterrupted());
        System.out.println(t2.getState());
    }
}
