package sukai.currency.caseVIII;

import sukai.currency.caseVI.SmallTool;

/**
 * @author chengsukai
 * @since 2022-08-16 16:46
 */
public class _04_beforehandInterrupt {
    public static void main(String[] args) {
        Thread.currentThread().interrupt();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        SmallTool.printTimeAndThread("结束睡眠");
    }

}
