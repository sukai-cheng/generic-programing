package sukai.currency.chapter17;

import java.util.concurrent.TimeUnit;

/**
 * @author chengsukai
 * @since 2022-08-29 10:30
 */
public class OOMTest {
    public static void main(String[] args) throws InterruptedException {

        LRUCache<Integer, Reference> cache = new LRUCache<>(200, key -> new Reference());
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            cache.get(i);
            TimeUnit.MILLISECONDS.sleep(100);
            System.out.println("The " + i + " reference stored at cache.");
            TimeUnit.SECONDS.sleep(2);
        }
    }
}
