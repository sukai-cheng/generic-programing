package sukai.currency.caseVI;

import java.util.concurrent.CompletableFuture;

/**
 * @author chengsukai
 * @since 2022-08-15 10:30
 */
public class _02_applyToEither {
    public static void main(String[] args) {
        SmallTool.printTimeAndThread("小白走出餐厅，来到公交站");
        SmallTool.printTimeAndThread("等待 700路 或者 800路 公交到来");

        CompletableFuture<String> bus = CompletableFuture.supplyAsync(() -> {
            SmallTool.printTimeAndThread("700路公交正在赶来");
            SmallTool.sleepMills(100);
            return "700路到了";
        }).applyToEither(CompletableFuture.supplyAsync(() -> {
            SmallTool.printTimeAndThread("800路公交正在赶来");
            SmallTool.sleepMills(200);
            return "800路到了";
            // 直接把先来的那人任务的结果返回
        }), firstComeBus -> {
            SmallTool.printTimeAndThread(firstComeBus);
            if (firstComeBus.startsWith("700")) {
                throw new RuntimeException("撞树了...");
            }
            return firstComeBus;
        }).exceptionally(e -> {
            SmallTool.printTimeAndThread(e.getMessage());
            SmallTool.printTimeAndThread("小白叫出租车");
            return "出租车 叫到了";
        });

        SmallTool.printTimeAndThread(String.format("%s,小白坐车回家", bus.join()));
    }
}
