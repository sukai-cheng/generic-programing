package sukai.selfannotation.casev;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author chengsukai
 * @since 2022-06-19 22:20
 */
public class InheritDemo {
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    @interface Test{

    }

    @Test
    static class Base{

    }

    static class Child extends Base{

    }

    public static void main(String[] args) {
        System.out.println(Child.class.isAnnotationPresent(Test.class));
    }
}
