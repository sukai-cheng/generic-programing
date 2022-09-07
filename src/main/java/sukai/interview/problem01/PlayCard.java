package sukai.interview.problem01;

import lombok.Data;

import java.util.LinkedList;
import java.util.List;

/**
 * @author chengsukai
 * @since 2022-09-06 13:03
 */
@Data
public class PlayCard {

    String value;
    Integer point;
    private static LinkedList<PlayCard> playCardLinkedList = new LinkedList<>();

    public PlayCard(String cardColor, Integer point) {

        this.value = cardColor;
        this.point = point;
    }

    public static void main(String[] args) {
        List<PlayCard> playCards = initCards();
        playCards.forEach(System.out::println);
        System.out.println(playCards.size());
    }

    public static List<PlayCard> initCards() {

        for (int i = 0; i < 4; i++) {
            addCard("A" , 1);
            for (int j = 2; j <= 10; j++) {
                addCard(String.valueOf(j), j);
            }
            addCard("J",11);
            addCard("Q",12);
            addCard("K",13);
        }

        addCard("black Joke" , 20);
        addCard("red Joke" , 20);


        return playCardLinkedList;
    }

    public static void addCard(String cardColor, Integer point) {
        playCardLinkedList.add(new PlayCard(cardColor, point));
    }
}
































