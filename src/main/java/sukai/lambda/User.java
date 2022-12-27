package sukai.lambda;

import lombok.Builder;
import lombok.Data;

/**
 * @author chengsukai
 * @since 2022-10-10 22:43
 */
@Builder
@Data
public class User {
    String name;
    String sex;
    Integer age;
}
