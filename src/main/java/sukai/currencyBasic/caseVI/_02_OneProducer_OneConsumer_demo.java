package sukai.currencyBasic.caseVI;

import sukai.currencyBasic.caseV.SmallTool;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * @author chengsukai
 * @since 2022-08-16 17:31
 */
public class _02_OneProducer_OneConsumer_demo {
    public static void main(String[] args) {
        Queue<String> shaobingQueue = new LinkedList<>();
        List<String> xiaoBaiMsg = new LinkedList<>();
        List<String> roadPeopleMsg = new LinkedList<>();

        Thread xiaoBai = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                String tmp = String.format("第%d个烧饼", i + 1);
                shaobingQueue.add(tmp);
                // 日志放入在队列中因为System.out有同步操作
                xiaoBaiMsg.add(String.format("%d 小白制作了 [%s]", System.currentTimeMillis(), tmp));
            }
        });

        Thread roadPeopleA = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                roadPeopleMsg.add(String.format("%d 路人甲 买到了 [%s]", System.currentTimeMillis(), shaobingQueue.poll()));
            }
        });
        xiaoBai.start();
        roadPeopleA.start();

        try {
            xiaoBai.join();
            roadPeopleA.join();

        } catch (InterruptedException e) {
            SmallTool.printTimeAndThread("join 产生中断" + e.getMessage());
        }

        System.out.println(xiaoBaiMsg.stream().collect(Collectors.joining("\n")));
        System.out.println("------------------------");
        System.out.println(roadPeopleMsg.stream().collect(Collectors.joining("\n")));
    }
}
