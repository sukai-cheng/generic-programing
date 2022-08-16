package sukai.functional.lambda.caseVI;

/**
 * @author chengsukai
 * @since 2022-08-06 14:26
 */
public class Test02 {

    // 该函数会接收一个Integer为参数并返回一个从Integer到Integer的函数
    static Function<Integer, Function<Integer, Integer>> add = x -> y -> x + y;
    static Function<Integer, Integer> add2 = x -> x;

    public static void main(String[] args) {
        System.out.println(add.apply(3).apply(4));
        System.out.println(add2.apply(3));
    }


}
