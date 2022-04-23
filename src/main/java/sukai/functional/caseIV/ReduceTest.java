package sukai.functional.caseIV;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @description stream-reduce
 *
 * @author chengsukai
 *
 * @create 2022-04-23 09:27
 **/
public class ReduceTest {

    public static void main(String[] args) {
        IntStream.range(1,10).skip(8).forEach(System.out::println);
        System.out.println(IntStream.range(1, 5).sum());
        Stream.of("Ava","Billion","Cow").sorted().forEach(System.out::print);
        Arrays.stream(new int[]{2,4,6,8,10}).map(x -> x*x).average().ifPresent(System.out::println);
        IntSummaryStatistics intSummaryStatistics = IntStream.of(7, 2, 19, 88, 73, 4, 10).summaryStatistics();
        System.out.println(intSummaryStatistics);
    }
}