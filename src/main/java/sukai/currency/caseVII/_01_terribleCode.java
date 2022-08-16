package sukai.currency.caseVII;

import sukai.currency.caseVI.SmallTool;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

/**
 * @author chengsukai
 * @since 2022-08-16 13:50
 */
public class _01_terribleCode {
    public static void main(String[] args) {

//        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "10");
        // 最好使用自定义线程池来做
        SmallTool.printTimeAndThread("小白和小伙伴们 进餐厅点菜");
        long startTime = System.currentTimeMillis();
//
//        ArrayList<Dish> dishes = new ArrayList<>();
//
//        for (int i = 1; i <= 10; i++) {
//            Dish dish = new Dish("菜" + i, 1);
//            dishes.add(dish);
//        }
//
//        ArrayList<CompletableFuture> cflist = new ArrayList<>();
//        for (Dish dish : dishes) {
//            CompletableFuture<Void> cf = CompletableFuture.runAsync(() -> dish.make());
//            cflist.add(cf);
//        }
//
//        CompletableFuture.allOf(cflist.toArray(new CompletableFuture[cflist.size()])).join();

        // return the number of processors available to the Java virtual machine
        System.out.println(Runtime.getRuntime().availableProcessors());
        // return current size of thread num
        System.out.println(ForkJoinPool.commonPool().getPoolSize());
        // return max thread num
        System.out.println(ForkJoinPool.getCommonPoolParallelism());
        CompletableFuture[] dishes = IntStream.rangeClosed(1, 10)
                .mapToObj(i -> new Dish("菜" + i, 1)).
                map(dish -> CompletableFuture.runAsync(dish::make)).
                toArray(size -> new CompletableFuture[size]);

        CompletableFuture.allOf(dishes).join();


        SmallTool.printTimeAndThread("菜都做好了，上桌" + (System.currentTimeMillis() - startTime));
    }
}
