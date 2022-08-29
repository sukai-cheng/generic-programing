package sukai.currency.chapter17;

/**
 * @author chengsukai
 * @since 2022-08-29 10:15
 */
@FunctionalInterface
public interface CacheLoader<K, V> {

    V load(K k);
}
