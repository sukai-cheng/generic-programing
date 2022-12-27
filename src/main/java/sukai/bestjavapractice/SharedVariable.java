package sukai.bestjavapractice;

import java.util.concurrent.TimeUnit;

/**
 * 共享变量不可见
 * @author chengsukai
 * @since 2022-12-27 13:16
 */
public class SharedVariable {
    private static boolean flag = true;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            while (flag) {

            }
            System.out.println("线程: " + Thread.currentThread().getName() + ", flag" + flag);
        }, "block_thread").start();
        TimeUnit.MICROSECONDS.sleep(500);
        new Thread(
                () -> {
                    flag = false;
                    System.out.println("线程: " + Thread.currentThread().getName() + ", flag" + flag);
                },
                "change_thread"
        ).start();
    }
}
