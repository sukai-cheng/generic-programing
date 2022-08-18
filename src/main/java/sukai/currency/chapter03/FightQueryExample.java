package sukai.currency.chapter03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author chengsukai
 * @since 2022-08-18 11:25
 */
public class FightQueryExample {
    private final static List<String> fightCompany = Arrays.asList("CSA", "CEA", "HNA");

    public static void main(String[] args) {
        List<String> result = new ArrayList<>();
        result = search("SH");
        result.forEach(System.out::println);
    }

    private static List<String> search(String original) {

        final List<String> result = new ArrayList<>();

        List<FightQueryTask> tasks = fightCompany.stream().map(f -> createSearchTask(f, original)).collect(toList());

        tasks.forEach(Thread::start);

        tasks.forEach(t -> {
            try {
                t.join(); // 等待join的线程都执行完，再执行主线程，主线程状态是Block
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        tasks.stream().map(FightQuery::get).forEach(result::addAll);

        return result;

    }

    private static FightQueryTask createSearchTask(
            String fight,
            String original
    ) {
        return new FightQueryTask(fight, original, "BJ");
    }
}
