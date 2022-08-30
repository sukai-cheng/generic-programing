package sukai.currencyBasic.caseI;

import java.util.concurrent.TimeUnit;

/**
 * @description 线程的生命周期
 *
 * @author chengsukai
 *
 * @create 2022-04-20 06:55
 **/
public class TryConcurrency {

    public void initAThread() {
        Thread thread = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        thread.start(); // 重复启动
    }

    public void initBThread() throws InterruptedException {
        Thread thread = new Thread(() -> {
            try{
                TimeUnit.SECONDS.sleep(1);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        });
        thread.start();
        TimeUnit.SECONDS.sleep(2);
        thread.start(); // 线程生命周期结束不可再次启动
    }


}