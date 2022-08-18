package sukai.currency.chapter03;

import sukai.currency.caseV.SmallTool;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * join某个线程A，会使线程B进入等待，直到线程A结束生命周期，或者达到给定的时间，在此期间B线程是处于BLOCKED状态
 *
 * @author chengsukai
 * @since 2022-08-18 10:59
 */
public class _06_ThreadJoin {
    public static void main(String[] args) throws InterruptedException {

        List<Thread> threads = IntStream.range(1, 3).mapToObj(_06_ThreadJoin::create).collect(Collectors.toList());

        threads.forEach(Thread::start);

        for (Thread thread : threads) {
            thread.join();
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "#" + i);
            shortSleep();
        }

    }

    private static Thread create(int seq) {
        return new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + '#' + i);
                SmallTool.sleepMills(100);
            }
        }, String.valueOf(seq));
    }

    private static void shortSleep() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
