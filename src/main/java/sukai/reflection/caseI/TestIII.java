package sukai.reflection.caseI;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author csk
 */
public class TestIII {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<StringBuilder> constructor = StringBuilder.class.getConstructor(new Class[]{int.class});
        StringBuilder sb = constructor.newInstance(100);
        System.out.println(sb);
    }
}
