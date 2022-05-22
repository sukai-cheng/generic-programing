package sukai.functional.stream.caseVI;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @description Stream对集合和数组进行操作
 *
 * @author chengsukai
 *
 * @create 2022-05-02 11:48
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Author {

    private Long id;

    private String name;

    private Integer age;

    private String intro;

    private List<Book> books;

}