package sukai.currency.caseVII;

import sukai.currency.caseVI.SmallTool;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

/**
 * @author chengsukai
 * @since 2022-08-16 13:50
 */
public class _01_terribleCode {
    public static void main(String[] args) {
        SmallTool.printTimeAndThread("小白和小伙伴们 进餐厅点菜");
        long startTime = System.currentTimeMillis();

        ArrayList<Dish> dishes = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            Dish dish = new Dish("菜" + i, 1);
            dishes.add(dish);
        }

        for (Dish dish : dishes) {
            CompletableFuture.runAsync(() -> dish.make()).join(); // 直接将异步任务变成了串行
        }

        SmallTool.printTimeAndThread("菜都做好了，上桌" + (System.currentTimeMillis() - startTime));
    }
}
