package sukai.currencyadvance.chapter06;

import java.util.concurrent.CompletableFuture;

/**
 * @author chengsukai
 * @since 2022-09-05 21:24
 */
public class ThenComposeExample {
    public static void main(String[] args) {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "Java").thenCompose(s -> CompletableFuture.supplyAsync(() -> s + " Scala"));
        completableFuture.thenApply(String::toUpperCase).thenAccept(System.out::println);
    }
}
