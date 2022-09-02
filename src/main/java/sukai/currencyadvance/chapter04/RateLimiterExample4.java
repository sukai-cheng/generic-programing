package sukai.currencyadvance.chapter04;

import static java.lang.Thread.currentThread;

/**
 * @author chengsukai
 * @since 2022-09-02 14:05
 */
public class RateLimiterExample4 {

    private static final RateLimiterTokenBucket TOKEN_BUCKET = new RateLimiterTokenBucket();

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                while (true) {
                    try {
                        TOKEN_BUCKET.bookOrder(prodID -> System.out.println("User: " + currentThread() + " book the prod order and prodID: " + prodID));
                    } catch (RateLimiterTokenBucket.NoProductionException e) {
                        System.out.println("all of production already sold out.");
                        break;
                    } catch (RateLimiterTokenBucket.OrderFailedException e) {
                        System.out.println("User: " + currentThread() + " book order failed, will try again.");
                    }
                }
            }).start();
        }
    }
}
