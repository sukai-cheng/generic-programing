package sukai.functional.stream.caseII;

import java.util.function.Consumer;

/**
 * @description
 *
 * @author chengsukai
 *
 * @create 2022-04-04 21:56
 **/
public class CommonFunctionalTest {
    public static void main(String[] args) {
        Consumer consumer = System.out::println;
        consumer.accept("Hello Function");
    }
}