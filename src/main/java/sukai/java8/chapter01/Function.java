package sukai.java8.chapter01;

@FunctionalInterface
public interface Function<T,R> {
    R apply(T t);
}
