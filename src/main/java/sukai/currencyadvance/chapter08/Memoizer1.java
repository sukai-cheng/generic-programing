package sukai.currencyadvance.chapter08;

import javax.annotation.concurrent.GuardedBy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author chengsukai
 * @since 2022-09-07 09:52
 */
public class Memoizer1<A, V> implements Computable<A, V> {

    @GuardedBy("this") //只有在线程持有this对象锁才能使用cache
    private final Map<A, V> cache = new ConcurrentHashMap<>();
    private final Computable<A, V> c;

    public Memoizer1(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public synchronized V compute(A arg) throws InterruptedException {
        V result = cache.get(arg);
        if (result == null) {
            result = c.compute(arg);
            cache.put(arg, result);
        }
        return result;
    }

}
