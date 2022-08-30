package sukai.currencyBasic.caseVI;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author chengsukai
 * @since 2022-08-16 17:31
 */
public class _01_Queue_demo {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.offer("one");
        queue.offer("two");
        queue.offer("three");

        System.out.println("----------start------------");
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println("----------stop------------");
    }
}
