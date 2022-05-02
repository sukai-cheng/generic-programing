package sukai.functional.lambda.caseI;

import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;

/**
 * @description lambda是对匿名内部类的优化
 *
 * @author chengsukai
 *
 * @create 2022-05-01 20:04
 **/
public class lambdaExample {

    public static void main(String[] args) {
//        printNum(value -> value % 2 == 0);
//        String name = "123";
//        typeConvert(name,Long::valueOf);
        foreachArr(System.out::println);
    }

    /**
     * 传入的是一个匿名内部类
     * 但这个匿名内部类被标记了FunctionalInterface => 可以使用lambda简化
     * @return void
     * @create 2022/5/1 8:09 PM
     * @author chengsukai
     */
    public static void printNum(IntPredicate predicate) {
        int[] arr = {1, 2, 3, 4, 5};
        for (int i : arr) {
            if (predicate.test(i)) {
                System.out.println(i);
            }
        }
    }

    /**
     * 调用函数式接口
     * @return void
     * @create 2022/5/2 11:23 AM
     * @author chengsukai
     */
    public static <R> void typeConvert(String str, Function<String, R> function) {
        System.out.println(function.apply(str));
    }

    public static void foreachArr(IntConsumer consumer){
        int[] arr = {1, 2, 3, 4, 5};
        for(int i : arr){
            consumer.accept(i);
        }
    }

}