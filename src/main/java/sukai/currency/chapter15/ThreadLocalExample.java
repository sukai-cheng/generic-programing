package sukai.currency.chapter15;

import sukai.currency.caseV.SmallTool;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static java.lang.Thread.currentThread;

/**
 * @author chengsukai
 * @since 2022-08-29 09:26
 */
public class ThreadLocalExample {
    public static void main(String[] args) {

        // 创建全局的ThreadLocal对于每一个进程而言都是独立的
        ThreadLocal<Integer> tlocal = new ThreadLocal<>();
        IntStream.range(0, 10).forEach(i -> new Thread(() -> {
                    try {
                        tlocal.set(i);
                        SmallTool.printTimeAndThread(currentThread() + " set i " + tlocal.get());

                        TimeUnit.SECONDS.sleep(1);

                        SmallTool.printTimeAndThread(currentThread() + " set i " + tlocal.get());

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }).start()
        );
    }
}
