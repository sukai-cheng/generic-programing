package sukai.interview.problem01;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author chengsukai
 * @since 2022-09-06 15:55
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        Game game = new Game();
        List<PlayCard> playCards = PlayCard.initCards();
        game.setCardList(playCards);
        new Thread(() -> {
            while (true) {
                game.produce();
            }
        }, "producer").start();
        TimeUnit.SECONDS.sleep(1);
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                try {
                    game.consumer();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }, "consumer-" + i).start();
        }
        System.out.println("hello");

    }
}
