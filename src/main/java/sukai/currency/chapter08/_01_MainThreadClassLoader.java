package sukai.currency.chapter08;

import static java.lang.Thread.currentThread;

/**
 * @author chengsukai
 * @since 2022-08-24 15:04
 */
public class _01_MainThreadClassLoader {
    public static void main(String[] args) {
        System.out.println(currentThread().getContextClassLoader());
    }
}
