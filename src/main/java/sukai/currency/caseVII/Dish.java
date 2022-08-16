package sukai.currency.caseVII;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sukai.currency.caseVI.SmallTool;

/**
 * @author chengsukai
 * @since 2022-08-16 13:51
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dish {
    String name;
    Integer productionTime;

    public void make() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        SmallTool.printTimeAndThread(this.name + "制作完毕，来吃我吧");
    }
}
