package sukai.currency.caseVIII;

import lombok.extern.slf4j.Slf4j;
import sukai.currency.caseVI.SmallTool;

import java.util.concurrent.TimeUnit;

/**
 * @author chengsukai
 * @since 2022-08-16 15:17
 */
@Slf4j
public class ThreadStateTest {
    public static void main(String[] args) {
        Thread thread = new Thread();
        System.out.println("1+ " + thread.getState());
        thread.start();
        System.out.println("2+ " + thread.getState());
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            SmallTool.printTimeAndThread("产生中断" + e.getMessage());
            log.error("线程中断");
        }
        System.out.println("3+" + thread.getState());
    }
}
