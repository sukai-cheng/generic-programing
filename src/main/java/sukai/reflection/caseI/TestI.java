package sukai.reflection.caseI;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

/**
 * @author csk
 */
public class TestI {
    public static void main(String[] args) throws IllegalAccessException {
        List<String> obj = Arrays.asList("老马", "编程");
        Class<?> cls = obj.getClass();
        for (Field f : cls.getDeclaredFields()) {
            f.setAccessible(true);
            System.out.println(f.getName() + " - " + f.get(obj));
        }
    }
}
