package sukai.functional.stream.caseVI;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @description
 *
 * @author chengsukai
 *
 * @create 2022-05-02 11:59
 **/
public class MapStream {

    public static void main(String[] args) {
        test();
    }
    public static void test() {

        Map<String, Integer> map = new HashMap<>();
        map.put("a", 19);
        map.put("b", 20);
        map.put("c", 21);

        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        Stream<Map.Entry<String, Integer>> stream = entries.stream();

        stream.filter(stringIntegerEntry -> stringIntegerEntry.getValue() >= 20)
                .map((Function<Map.Entry<String, Integer>, Object>) Map.Entry::getValue)
                .forEach(System.out::println);
    }

}