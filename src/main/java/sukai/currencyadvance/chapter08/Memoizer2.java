package sukai.currencyadvance.chapter08;

import javax.annotation.concurrent.GuardedBy;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @author chengsukai
 * @since 2022-09-07 09:52
 */
public class Memoizer2<A, V> implements Computable<A, V> {

    @GuardedBy("this") //只有在线程持有this对象锁才能使用cache
    private final Map<A, Future<V>> cache = new ConcurrentHashMap<>();
    private final Computable<A, V> c;

    public Memoizer2(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public V compute(final A arg) throws InterruptedException {
        while (true) {
            Future<V> f = cache.get(arg);
            if (f == null) {
                Callable<V> eval = () -> c.compute(arg);
                FutureTask<V> ft = new FutureTask<>(eval);
                f = cache.putIfAbsent(arg, ft);
                cache.put(arg, ft);
                ft.run();
            }
            try {
                assert f != null;
                return f.get();//如果没有获取到结果就一直阻塞
            } catch (CancellationException e) {
                cache.remove(arg, f);
            } catch (ExecutionException e) {
                throw new RuntimeException(e.getCause());
            }
        }

    }

}
