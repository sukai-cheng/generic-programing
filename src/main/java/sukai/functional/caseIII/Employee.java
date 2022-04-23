package sukai.functional.caseIII;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @description
 *
 * @author chengsukai
 *
 * @create 2022-04-18 17:31
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements Serializable {

    private static final long serialVersionUID = -3746891874285124056L;

    Long id;
    String name;
    String career;
}