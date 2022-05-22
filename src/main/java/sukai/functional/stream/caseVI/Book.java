package sukai.functional.stream.caseVI;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @description
 *
 * @author chengsukai
 *
 * @create 2022-05-02 11:48
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Book {

    private Long id;

    private String name;

    private String category;

    private Integer score;

    private String intro;

}