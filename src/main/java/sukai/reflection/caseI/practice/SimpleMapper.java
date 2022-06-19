package sukai.reflection.caseI.practice;

import cn.hutool.core.util.StrUtil;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * @author csk
 */
public class SimpleMapper {
    public static String toString(Object obj) {
        try {
            Class<?> cls = obj.getClass();
            StringBuilder sb = new StringBuilder();
            sb.append(cls.getName()).append("\n");
            for (Field f : cls.getDeclaredFields()) {
                // 如果没有实例对象
                if (!f.canAccess(obj)) {
                    f.setAccessible(true);
                }
                sb.append(f.getName()).append(" = ").append(f.get(obj).toString()).append("\n");
            }
            return sb.toString();
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static Object fromString(String str) {

        try {
            String[] lines = str.split("\n");
            if (lines.length < 1) {
                throw new IllegalArgumentException(str);
            }
            Class<?> cls = Class.forName(lines[0]);
            Object obj = cls.getDeclaredConstructor().newInstance();
            if (lines.length > 1) {
                for (int i = 1; i < lines.length; i++) {
                    String[] fv = lines[i].split("=");
                    if (fv.length != 2) {
                        throw new IllegalArgumentException(lines[i]);
                    }
                    Field f = cls.getDeclaredField(help(fv[0]));
                    if (!f.canAccess(obj)) {
                        f.setAccessible(true);
                    }
                    setFieldValue(f, obj, fv[1]);
                }
            }
            return obj;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static String help(String s) {
        return StrUtil.cleanBlank(s).replace("\"", "");
    }

    private static void setFieldValue(Field f, Object obj, String value) throws Exception {
        Class<?> type = f.getType();
        if (type == int.class) {
            f.setInt(obj, Integer.parseInt(help(value)));
        } else if (type == byte.class) {
            f.setByte(obj, Byte.parseByte(help(value)));
        } else if (type == short.class) {
            f.setShort(obj, Short.parseShort(help(value)));
        } else if (type == long.class) {
            f.setLong(obj, Long.parseLong(help(value)));
        } else if (type == float.class) {
            f.setFloat(obj, Float.parseFloat(help(value)));
        } else if (type == double.class) {
            f.setDouble(obj, Double.parseDouble(help(value)));
        } else if (type == boolean.class) {
            f.setBoolean(obj, Boolean.parseBoolean(help(value)));
        } else if (type == String.class) {
            f.set(obj, value);
        } else if (type == char.class) {
            f.setChar(obj, value.charAt(0));
        } else {
            Constructor<?> ctor = type.getConstructor(String.class);
            f.set(obj, ctor.newInstance(value));
        }
    }
}



































