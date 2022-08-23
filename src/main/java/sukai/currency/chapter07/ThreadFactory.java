package sukai.currency.chapter07;

/**
 * @author chengsukai
 * @since 2022-08-23 17:28
 */
public interface ThreadFactory {
    Thread createThread(Runnable runnable);
}
