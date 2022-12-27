package sukai.selfannotation.casev;

import java.lang.reflect.Field;

/**
 * @author chengsukai
 * @since 2022-06-20 09:01
 */
public class SimpleContainer {

    public static <T> T getInstance(Class<T> cls) {

        try {
            T obj = cls.getDeclaredConstructor().newInstance();
            Field[] fields = cls.getDeclaredFields();
            for (Field f : fields) {
                if (f.isAnnotationPresent(sukai.selfannotation.caseV.SimpleInject.class)) {
                    if (!f.canAccess(obj)) {
                        f.setAccessible(true);
                    }
                    Class<?> fieldCls = f.getType();
                    f.set(obj, getInstance(fieldCls));
                }
            }
            return obj;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
