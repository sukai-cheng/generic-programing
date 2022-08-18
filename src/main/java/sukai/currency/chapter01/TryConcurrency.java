package sukai.currency.chapter01;

import sukai.currency.caseV.SmallTool;

/**
 * @author chengsukai
 * @since 2022-08-17 12:44
 */
public class TryConcurrency {
    public static void main(String[] args) {

        new Thread(TryConcurrency::browseNews,"小白").start();
        new Thread(TryConcurrency::enjoyMusic,"小黑").start();
    }

    private static void browseNews() {
        while (true) {
            SmallTool.printTimeAndThread("Uh-huh, the good news.");
            SmallTool.sleepMills(1000);
        }
    }

    private static void enjoyMusic() {
        while (true) {
            SmallTool.printTimeAndThread("Uh-huh, the nice music.");
            SmallTool.sleepMills(1000);
        }
    }
}
