package sukai.interview.problem01;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.currentThread;

/**
 * @author chengsukai
 * @since 2022-09-06 13:18
 */
@Setter
@Getter
public class Game {

    List<PlayCard> cardList;
    static LinkedList<PlayCard> cardQueue = new LinkedList<>();
    private static final Lock lock = new ReentrantLock();
    private static final Condition CONDITIONProduce = lock.newCondition();
    private static final Condition CONDITIONConsumer = lock.newCondition();
    private volatile boolean cancelled = false;

    ThreadLocal<AtomicInteger> score = ThreadLocal.withInitial(() -> new AtomicInteger(0));

    AtomicInteger round = new AtomicInteger(0);

    public void produce() {

        lock.lock();
        try {
            while (cardQueue.size() != 0) {
                CONDITIONProduce.await();
            }
            Random random = new Random();
            for (int i = 0; i < 3; i++) {
                int randomIndex = random.nextInt(3);
                cardQueue.add(cardList.get(randomIndex));
            }
            System.out.println(Arrays.toString(cardQueue.toArray()));
            CONDITIONConsumer.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void consumer() throws InterruptedException {

        while (!cancelled) {
            lock.lock();
            try {
                while (cardQueue.size() == 0) {
                    CONDITIONConsumer.await();
                }
                PlayCard card = cardQueue.poll();
                Integer point = card.getPoint();
                int currentScore = score.get().addAndGet(point);
                System.out.println(currentThread() + "-->" + currentScore);

                if (currentScore >= 50) {
                    throw new InterruptedException();
                }
            } catch (InterruptedException e) {
                System.out.println(currentThread() + " wined");
                isCancelled();
            } finally {
                CONDITIONProduce.signalAll();
                lock.unlock();
                TimeUnit.MILLISECONDS.sleep(100);
            }
        }
    }

    public void isCancelled() {
        cancelled = true;
    }
}
