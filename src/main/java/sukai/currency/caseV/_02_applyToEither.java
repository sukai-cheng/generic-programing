package sukai.currency.caseV;

import java.util.concurrent.CompletableFuture;

/**
 * @author chengsukai
 * @since 2022-08-15 10:30
 */
public class _02_applyToEither {
    public static void main(String[] args) {

        SmallTool.printTimeAndThread("建立连接中...");
        CompletableFuture<String> bus = CompletableFuture.supplyAsync(() -> {
            SmallTool.sleepMills(1000);
            SmallTool.printTimeAndThread("连接超时");
            return "结束通话";
        }).applyToEither(CompletableFuture.supplyAsync(() -> {
            SmallTool.sleepMills(1200);
            SmallTool.printTimeAndThread("连接成功");
            SmallTool.printTimeAndThread("开始通话");
            return "开始通话";
            // 直接把先来的那人任务的结果返回
        }), firstComeBus -> firstComeBus);

        SmallTool.printTimeAndThread(String.format("%s,------------，结束通话", bus.join()));
    }
}
