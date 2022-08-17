package sukai.currency.caseVI;

import sukai.currency.caseV.SmallTool;

import java.util.concurrent.CompletableFuture;

/**
 * @author chengsukai
 * @since 2022-08-16 09:46
 */
public class _01_MethodPrompt {
    public static void main(String[] args) {
        CompletableFuture cf1 = CompletableFuture.supplyAsync(() -> {
            SmallTool.printTimeAndThread("厨师炒菜");
            SmallTool.sleepMills(200);
            return "番茄炒蛋";
        }).thenComposeAsync(dish -> {

            // 进程复用, 实际只有3个异步任务
            SmallTool.printTimeAndThread("服务员A 准备打饭， 但是中途有事， 打饭交给服务员B");

            return CompletableFuture.supplyAsync(() -> {
                SmallTool.printTimeAndThread("服务员B 打饭");
                SmallTool.sleepMills(100);
                return dish + "米饭";
            });
        });
        SmallTool.printTimeAndThread(cf1.join() + "好了开饭");
    }
}
