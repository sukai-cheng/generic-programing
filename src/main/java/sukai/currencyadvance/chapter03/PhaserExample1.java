package sukai.currencyadvance.chapter03;

import java.util.Date;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.currentThread;
import static java.util.concurrent.ThreadLocalRandom.current;

/**
 * @author chengsukai
 * @since 2022-08-31 13:05
 */
public class PhaserExample1 {
    public static void main(String[] args) throws InterruptedException {
        final Phaser phaser
                = new Phaser();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                phaser.register(); //让Phaser内部的分片加一，待10个线程分别执行了register方法之后，此时的分片parties就成了10
                try {
                    TimeUnit.SECONDS.sleep(current().nextInt(20));
                    //代表着当前线程已经到达了这个屏障，但是它不需要等待其他线程也到达该屏障，因为该方法不是阻塞方法，执行之后会返回
                    phaser.arrive();
                    System.out.println(new Date() + ":" + currentThread() + " completed the work.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "T-" + i).start();
        }
        TimeUnit.SECONDS.sleep(1);
        phaser.register(); // 此时Phaser的parties就为11了
        phaser.arriveAndAwaitAdvance();//表示当前线程已经到达了这个屏障，等待其他线程也到达这个屏障，等待所有子线程完成任务
        assert phaser.getRegisteredParties() == 11 : "total 11 parties is registered.";
        System.out.println(new Date() + ": all of sub task completed work.");
    }
}
