package sukai.currencyBasic.chapter11;

import sukai.currencyBasic.caseV.SmallTool;

/**
 * @author chengsukai
 * @since 2022-08-26 11:11
 */
public interface TaskLifecycle<T> {
    void onStart(Thread thread);

    void onRunning(Thread thread);

    void onFinish(Thread thread, T result);

    void onError(Thread thread, Exception e);

    /**
     * @author chengsukai
     * @since 2022-08-26 11:12
     */
    public class EmptyLifecycle<T> implements TaskLifecycle<T> {
        @Override
        public void onStart(Thread thread) {
            SmallTool.printTimeAndThread("current thread state is start ...");
        }

        @Override
        public void onRunning(Thread thread) {
            SmallTool.printTimeAndThread("current thread state is running ...");
        }

        @Override
        public void onFinish(Thread thread, T result) {
            SmallTool.printTimeAndThread("current thread state is finished ...");
        }

        @Override
        public void onError(Thread thread, Exception e) {
            SmallTool.printTimeAndThread("current thread state has error ...");
        }
    }

}
