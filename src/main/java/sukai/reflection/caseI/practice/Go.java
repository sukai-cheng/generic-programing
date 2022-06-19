package sukai.reflection.caseI.practice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author chengsukai
 * @since 2022-06-19 18:18
 */
public class Go {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("承苏凯");
        student.setAge(27);
        student.setGender('N');
        String s = SimpleMapper.toString(student);
        System.out.println(s);
        System.out.println("======================");
        Object o = SimpleMapper.fromString(s);
        System.out.println(o);
    }


}

@Getter
@Setter
@AllArgsConstructor
class Student{
    public String name;
    public int age;
    public char gender;

    public Student() {

    }


}
