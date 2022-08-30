package sukai.currencyBasic.chapter19;

import sukai.currencyBasic.chapter11.Task;

/**
 * @author chengsukai
 * @since 2022-08-29 15:08
 */
public interface FutureService<IN, OUT> {

    Future<?> submit(Runnable runnable);

    Future<OUT> submit(Task<IN, OUT> task, IN input);

    static <T, R> FutureService<T, R> newService() {
        return new FutureServiceImpl<>();
    }
}
