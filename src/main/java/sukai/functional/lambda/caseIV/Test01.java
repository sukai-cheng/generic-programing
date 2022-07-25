package sukai.functional.lambda.caseIV;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author chengsukai
 * @since 2022-07-25 14:01
 */
public class Test01 {
    public static void main(String[] args) {
        List<Integer> pointList = new ArrayList<>();
        pointList.add(5);
        pointList.add(4);
        pointList.add(2);
        pointList.add(1);
        pointList.add(3);

//        Comparator<Integer> byX = new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return Integer.compare(o1, o2);
//            }
//        };
//
//        Comparator<Integer> byXRefactor = Integer::compare;


//        bad style
//        AtomicInteger sum = new AtomicInteger();
//        pointList.forEach(sum::addAndGet);
//        System.out.println(sum);

//        better style
//        int sum = pointList.stream()
//                .mapToInt(Integer::intValue)
//                .sum();
//        System.out.println(sum);


    }
}
