package sukai.java8.chapter01;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ConsumerTest {
    public static <T> void forEach(List<T> list, Consumer<T> c) {
        for (T t : list) {
            c.accept(t);
        }
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        list.sort(Comparator.comparing((Integer i) -> i).reversed());
        forEach(list, System.out::println);

    }
}
