package sukai.reflection.caseI;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author csk
 */
public class TestII {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //获得指定参数的构造方法
        HashMap<String, Integer> map = HashMap.class.getDeclaredConstructor().newInstance();
        map.put("Hello", 123);

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " - - " + entry.getValue());
        }
    }
}
