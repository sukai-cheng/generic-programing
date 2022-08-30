package sukai.currencyBasic.chapter14;

import sukai.currencyBasic.caseV.SmallTool;

import java.util.LinkedList;
import java.util.Random;

/**
 * @author chengsukai
 * @since 2022-08-28 20:23
 */
public class GuardedSuspensionQueue {
    private final LinkedList<Integer> queue = new LinkedList<>();

    private final int LIMIT = 100;

    public void offer(Integer data) throws InterruptedException {
        synchronized (this) {
            while (queue.size() >= LIMIT) {
                this.wait();
            }
            SmallTool.printTimeAndThread("生产了一个");
            queue.addLast(data);
            this.notifyAll();
        }
    }

    public Integer take() throws InterruptedException {
        synchronized (this) {
            while (queue.isEmpty()) {
                this.wait();
            }
            this.notifyAll();
            SmallTool.printTimeAndThread("消费了一个");
            return queue.removeFirst();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        GuardedSuspensionQueue guardedSuspensionQueue = new GuardedSuspensionQueue();
        Random random = new Random();
        Thread providerThread = new Thread(() -> {
            try {
                while (true) {
                    guardedSuspensionQueue.offer(random.nextInt(10));
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread consumerThread = new Thread(() -> {
            try {
                while (true) {
                    guardedSuspensionQueue.take();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        providerThread.start();

        Thread.sleep(300);

        consumerThread.start();


    }


}
