package sukai.currencyBasic.chapter19;

/**
 * @author chengsukai
 * @since 2022-08-29 14:55
 */
public interface Future<T> {
    // return the result of the calculation
    T get() throws InterruptedException;

    // determine whether the task has been executed
    boolean done();
}
