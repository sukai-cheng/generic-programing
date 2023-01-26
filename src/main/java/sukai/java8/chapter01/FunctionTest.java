package sukai.java8.chapter01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;

public class FunctionTest {

    public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
        List<R> res = new ArrayList<>();
        for (T t : list) {
            res.add(f.apply(t));
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> res = map(Arrays.asList("lambda", "in", "action"), String::length);
        System.out.println(res);
    }
}
