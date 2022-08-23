package sukai.currency.chapter06;

import java.util.concurrent.TimeUnit;

/**
 * @author chengsukai
 * @since 2022-08-23 16:31
 */
public class _03_UncaughtExceptionHandler {
    public static void main(String[] args) {
        // 设置的回调接口将获得该异常信息
        Thread.setDefaultUncaughtExceptionHandler((t, e) -> {
            System.out.println(t.getName() + " occur exception");
            e.printStackTrace();
        });

        final Thread thread = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {

            }
            System.out.println(1 / 0);
        }, "Test-Thread");

        thread.start();
    }

}
