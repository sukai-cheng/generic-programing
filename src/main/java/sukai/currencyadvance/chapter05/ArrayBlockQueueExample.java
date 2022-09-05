package sukai.currencyadvance.chapter05;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author chengsukai
 * @since 2022-09-02 14:47
 */
public class ArrayBlockQueueExample {
    public static void main(String[] args) {
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(10);
        IntStream.rangeClosed(0, 10).boxed().map(i -> new Thread("P-Thread-" + i) {

            @Override
            public void run() {
                while (true) {
                    try {
                        String data = String.valueOf(System.currentTimeMillis());
                        queue.put(data);
                        System.out.println(currentThread() + " produce data: " + data);
                        TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(5));
                    } catch (InterruptedException e) {
                        System.out.println("Received the interrupt SIGNAL.");
                        break;
                    }
                }
            }
        }).forEach(Thread::start);

        IntStream.rangeClosed(0, 10).boxed().map(i -> new Thread("C-Thread-" + i) {
            @Override
            public void run() {
                while (true) {
                    try {
                        String data = queue.take();
                        System.out.println(currentThread() + " consume data: " + data);
                        TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(5));
                    } catch (InterruptedException e) {
                        System.out.println("Received the interrupt SIGNAL.");
                        break;
                    }
                }
            }
        }).forEach(Thread::start);
    }


}
