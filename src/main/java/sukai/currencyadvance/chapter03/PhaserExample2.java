package sukai.currencyadvance.chapter03;

import java.util.Date;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.currentThread;
import static java.util.concurrent.ThreadLocalRandom.current;

/**
 * @author chengsukai
 * @since 2022-09-01 10:41
 */
public class PhaserExample2 {
    public static void main(String[] args) throws InterruptedException {
        final Phaser pa
                = new MyPhaser(() -> System.out.println(new Date() + ": all of subtask completed work"));
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                pa.register();
                try {
                    TimeUnit.SECONDS.sleep(current().nextInt(20));
                    pa.arriveAndAwaitAdvance();//在这里等所有线程都执行完，然后再走这一步
                    System.out.println(new Date() + ":" + currentThread() + " completed the work.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "T-" + i).start();
        }
    }

    private static class MyPhaser extends Phaser {
        private final Runnable runnable;

        private MyPhaser(Runnable runnable) {
            this.runnable = runnable;
        }

        // 当parties个任务都到达某个phase时该方法将被调用执行
        // 当执行onAdvance耗时较长，当有新的phase通过register方法加入到Phaser中就会陷入阻塞
        @Override
        protected boolean onAdvance(int phase, int registeredParties) {
            this.runnable.run();
            return super.onAdvance(phase, registeredParties);
        }


    }
}
