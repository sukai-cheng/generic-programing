package sukai.currencyBasic.chapter19;

/**
 * @author chengsukai
 * @since 2022-08-29 15:14
 */
public class FutureTask<T> implements Future<T> {

    private T result;
    private boolean isDone = false;
    private final Object LOCK = new Object();

    protected void finish(T result) {
        synchronized (LOCK) {
            if (isDone) {
                return;
            }
            this.result = result;
            this.isDone = true;
            LOCK.notifyAll();
        }
    }

    @Override
    public T get() throws InterruptedException {
        synchronized (LOCK) {
            while (!isDone) {
                LOCK.wait();
            }
            return result;
        }
    }

    @Override
    public boolean done() {
        return isDone;
    }
}
