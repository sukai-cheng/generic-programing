package sukai.java8.chapter01;

import cn.hutool.core.io.LineHandler;

import java.util.Scanner;

public class Pipline {

    static java.util.function.Function<String, String> addHeader = Letter::addHeader;
    static java.util.function.Function<String, String> transformationPipeline = addHeader.andThen(Letter::checkStyle).andThen(Letter::addFooter);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputFromConsole = scanner.nextLine();
        transformationPipeline(inputFromConsole);
    }

    private static void transformationPipeline(String message) {
        System.out.println(transformationPipeline.apply(message));
    }

}

class Letter {

    public static String addHeader(String text) {
        return "From AA: " + text;
    }

    public static String addFooter(String text) {
        return text + " Kind regarda";
    }

    public static String checkStyle(String text) {
        return text.replaceAll("landa", "lambda");
    }
}
