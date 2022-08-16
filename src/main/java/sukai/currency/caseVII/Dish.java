package sukai.currency.caseVII;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    public long make() {
        long startTime = System.currentTimeMillis();
        long result = 0;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
           result += i * i % 3;
        }
        return System.currentTimeMillis() - startTime;
    }
}
