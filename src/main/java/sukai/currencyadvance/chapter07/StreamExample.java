package sukai.currencyadvance.chapter07;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author chengsukai
 * @since 2022-09-06 11:15
 */
public class StreamExample {

    public static void main(String[] args) {
//        Stream.of(2, 4535, 565667, 2424, 565).map(i -> new int[]{i, String.valueOf(i).length()})
//                .forEach(entry -> System.out.printf("%d is %d digits.\n" , entry[0], entry[1]));
//        peekTest();
        doSomething();
    }

    private static Stream<String> fromCollection() {
        Collection<String> list = Arrays.asList("Hello" , "Stream");
        return list.stream();
    }

    private static Stream<Map.Entry<String, String>> fromMap() {
        return new HashMap<String, String>() {
            {
                put("Hello" , "Stream");
                put("Java" , "Programming");
            }
        }.entrySet().stream();
    }

    private static void peekTest() {
        int result = IntStream.range(0, 10).peek(System.out::println).map(i -> i * 2).peek(System.out::println).filter(i -> i > 10).peek(System.out::println).sum();
        System.out.println(result);
    }

    private static void doSomething() {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6).flatMap(i -> Stream.of(i, i * 2, i * i));
        integerStream.forEach(System.out::println);
    }


}
