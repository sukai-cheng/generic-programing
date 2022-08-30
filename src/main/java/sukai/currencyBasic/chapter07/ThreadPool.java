package sukai.currencyBasic.chapter07;

/**
 * @author chengsukai
 * @since 2022-08-23 17:23
 */
public interface ThreadPool {

    /**
     * 接受提交的runnable任务
     * @param runnable
     */
    void execute(Runnable runnable);

    /**
     * 关闭并且销毁线程池
     */
    void shutdown();

    /**
     * 返回线程池的初始线程数量
     * @return
     */
    int getInitSize();

    /**
     * 返回线程池最大的线程数量
     * @return
     */
    int getMaxSize();

    /**
     * 返回核心线程数量
     * @return
     */
    int getCoreSize();

    /**
     * 返回当前线程池任务数量
     * @return
     */
    int getQueueSize();

    /**
     * 返回线程池中当前活跃的线程数量
     * @return
     */
    int getActiveCount();

    /**
     * 判断线程池是否已经被销毁
     * @return
     */
    boolean isShutdown();
}
