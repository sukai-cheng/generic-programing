package sukai.java8.chapter01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class AppleTest {
    public static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor());
    }

    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }

    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if ("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterHeavyApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getWeight() > 150) {
                result.add(apple);
            }
        }
        return result;
    }

    static <T> List<T> filterApples(List<T> inventory,
                                    Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }


    public static void prettyPrintApple(List<Apple> inventory,
                                        AppleFormat appleFormat) {
        for (Apple apple :
                inventory) {
            String output = appleFormat.accept(apple);
            System.out.println(output);
        }
    }

    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(new Apple(80, "green"),
                new Apple(155, "green"),
                new Apple(120, "red"));

//        List<Apple> result = filterApples(inventory, AppleTest::isGreenApple);
        List<Apple> result = filterApples(inventory, (Apple apple) ->
                "red".equals(apple.getColor())
        );
        System.out.println(result);
        // fixme 需要声明很多实例化一次的类
//        prettyPrintApple(inventory, new AppleFancyFormatter());

    }
}
