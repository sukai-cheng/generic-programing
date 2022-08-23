package sukai.currency.chapter07;

/**
 * @author chengsukai
 * @since 2022-08-23 20:33
 */
public class DefaultThreadFactory implements ThreadFactory {
    @Override
    public Thread createThread(Runnable runnable) {
        return new Thread(runnable);
    }
}
