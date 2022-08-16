package sukai.currency.caseV;

import java.util.StringJoiner;

/**
 * @author chengsukai
 * @since 2022-08-15 09:41
 */
public class SmallTool {
    public static void sleepMills(long mills) {
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void printTimeAndThread(String tag) {
        String result = new StringJoiner("\t|\t").add(String.valueOf(System.currentTimeMillis())).add(String.valueOf(Thread.currentThread().getId())).add(Thread.currentThread().getName()).add(tag).toString();
        System.out.println(result);
    }
}
