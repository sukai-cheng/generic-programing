package sukai.java8.chapter01;

@FunctionalInterface
public interface Consumer<T> {
    void accept(T t);
}
