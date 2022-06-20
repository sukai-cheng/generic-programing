package sukai.selfannotation.casevl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author chengsukai
 * @since 2022-06-19 22:27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Label("姓名")
    String name;

    @Label("出生日期")
    @Format(pattern = "yyyy/MM/dd")
    Date born;

    @Label("分数")
    double score;
}
