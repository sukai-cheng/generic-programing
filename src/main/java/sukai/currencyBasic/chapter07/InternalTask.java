package sukai.currencyBasic.chapter07;

/**
 * @author chengsukai
 * @since 2022-08-23 20:10
 */
public class InternalTask implements Runnable {

    private final RunnableQueue runnableQueue;

    private volatile boolean running = true;


    public InternalTask(RunnableQueue runnableQueue) {
        this.runnableQueue = runnableQueue;
    }

    @Override
    public void run() {
        while (running && !Thread.currentThread().isInterrupted()) {
            try {
                Runnable task = runnableQueue.take();
                task.run();
            } catch (InterruptedException e) {
                running = false;
                break;
            }
        }
    }

    public void stop() {
        this.running = false;
    }
}
