package sukai.functional.lambda.chapter03.test01;

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author chengsukai
 * @since 2022-07-25 14:59
 */
public class test01 {
    public static void main(String[] args) {
//        IntStream.iterate(1, i -> i * 2).limit(10).forEach(System.out::println);
//        Optional<Integer> max = Stream.of(1,2,3,4,5)
//                .map(i -> i + 1)
//                .max(Integer::compareTo);
//
//        System.out.println(max.get());
//        OptionalInt max = IntStream.rangeClosed(1, 10).map(i -> i + 1).max();
//        System.out.println(max.getAsInt());

        Stream<Integer> integerStream = Stream.of(1, 2);
        IntStream intStream = integerStream.mapToInt(Integer::intValue);
    }
}
