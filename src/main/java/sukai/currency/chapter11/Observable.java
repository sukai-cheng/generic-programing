package sukai.currency.chapter11;

/**
 * @author chengsukai
 * @since 2022-08-26 11:09
 */
public interface Observable {
    enum Cycle{
        STARTED, RUNNING, DONE, ERROR
    }

    Cycle getCycle();

    void start();

    void interrupt();
}
