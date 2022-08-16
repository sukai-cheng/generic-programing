package sukai.currency.caseVI;

import java.util.concurrent.CompletableFuture;

/**
 * @author chengsukai
 * @since 2022-08-15 09:44
 */
public class _01_supplyAsync {
    public static void main(String[] args) {
        SmallTool.printTimeAndThread("小白进入餐厅");
        SmallTool.printTimeAndThread("小白点了 番茄炒蛋 + 一碗米饭");

        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {
            SmallTool.printTimeAndThread("厨师炒菜");
            SmallTool.sleepMills(200);
            return "番茄炒蛋";
        }).thenCombine(CompletableFuture.supplyAsync(() -> {
            SmallTool.printTimeAndThread("服务员蒸饭");
            SmallTool.sleepMills(100);
            return "米饭";
        }), (dish, rice) -> {
            // 将两个异步任务的结果转化为一个值
            SmallTool.printTimeAndThread("服务员打饭");
            SmallTool.sleepMills(100);
            return String.format("%s + %s 好了", dish, rice);
        });

        SmallTool.printTimeAndThread("小白在打王者");
        SmallTool.printTimeAndThread(String.format("%s,小白开吃", cf1.join()));
    }
}
