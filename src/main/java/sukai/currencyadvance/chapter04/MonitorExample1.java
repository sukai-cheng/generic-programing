package sukai.currencyadvance.chapter04;

import com.google.common.util.concurrent.Monitor;

import static java.lang.Thread.currentThread;

/**
 * @author chengsukai
 * @since 2022-09-02 10:32
 */
public class MonitorExample1 {
    private static Monitor monitor = new Monitor();
    private static int x = 0;
    private static final int MAX_VALUE = 10;

    // 创建锁
    private static final Monitor.Guard INC_WHEN_LESS_10 = new Monitor.Guard(monitor) {

        // 该方法就相当于我们在写对象监视器或者Condition时的临界值判断逻辑
        @Override
        public boolean isSatisfied() {
            return x < MAX_VALUE;
        }
    };

    public static void main(String[] args) throws InterruptedException {
        while (true) {
            // 锁当前线程，具备临界值的判断
            monitor.enterWhen(INC_WHEN_LESS_10);
            try {
                x++;
                System.out.println(currentThread() + ": x value is: " + x);
            } finally {
                monitor.leave(); //唤醒与Guard关联的Condition阻塞队列中的某个阻塞线程
            }
        }
    }
}
