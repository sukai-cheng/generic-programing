package sukai.currency.chapter03;

import sukai.currency.caseV.SmallTool;

import java.util.concurrent.TimeUnit;

/**
 * @author chengsukai
 * @since 2022-08-18 13:11
 */
public class FlagThreadExit {
    static class MyTask extends Thread {
        private volatile boolean close = false;

        @Override
        public void run() {

            SmallTool.printTimeAndThread("I will start work");
            while (!close && !isInterrupted()) {

            }
            SmallTool.printTimeAndThread("I will be exiting");
        }

        public void close() {
            this.close = true;
            this.interrupt();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyTask t = new MyTask();
        t.start();
        TimeUnit.SECONDS.sleep(1);
        SmallTool.printTimeAndThread("System will be shutdown");
        t.close();
    }
}
