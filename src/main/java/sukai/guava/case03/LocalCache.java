package sukai.guava.case03;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.TimeUnit;

/**
 * 构建本地缓存
 * @author chengsukai
 * @since 2022-11-18 13:37
 */
public class LocalCache {
    public static void main(String[] args) {
        Cache<String, String> cache = CacheBuilder.newBuilder()
                .expireAfterAccess(1, TimeUnit.MINUTES)
                .maximumSize(200)
                .build();
    }
}
