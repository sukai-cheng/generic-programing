package sukai.currency.chapter18;

/**
 * @author chengsukai
 * @since 2022-08-29 13:57
 */
public class ProductionChannel {

    // 传送带上最多可以有多少个袋加工的产品
    private final static int MAX_PROD = 100;
    private final Production[] productionQueue;
    private int tail;
    private int head;
    // 当前在流水线上有多少个待加工的产品
    private int total;

    private final Worker[] workers;


    public ProductionChannel(int workerSize) {
        this.workers = new Worker[workerSize];
        this.productionQueue = new Production[MAX_PROD];

        for (int i = 0; i < workerSize; i++) {
            workers[i] = new Worker("Worker-" + i, this);
            workers[i].start();
        }
    }

    public void offerProduction(Production production) {
        synchronized (this) {
            while (total >= productionQueue.length) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            productionQueue[tail] = production;
            tail = (tail + 1) % productionQueue.length;
            total++;
            this.notifyAll();
        }
    }

    public Production takeProduction() {
        synchronized (this) {
            while (total <= 0) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            Production prod = productionQueue[head];
            head = (head + 1) % productionQueue.length;
            total--;
            this.notifyAll();
            return prod;
        }
    }
}
