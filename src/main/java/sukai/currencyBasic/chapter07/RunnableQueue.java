package sukai.currencyBasic.chapter07;

/**
 * @author chengsukai
 * @since 2022-08-23 17:27
 */
public interface RunnableQueue {

    void offer(Runnable runnable);

    Runnable take() throws InterruptedException;

    int size();
}
