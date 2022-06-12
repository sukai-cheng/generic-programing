package sukai.selfannotation.utils;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import sukai.selfannotation.caseI.Gender;
import sukai.selfannotation.caseI.Name;
import sukai.selfannotation.caseI.Profile;

import java.lang.reflect.Field;


public class CustomUtils {
    private static final Log log = LogFactory.get("自定义注解日志");

    public static void getInfo(Class<?> clazz) {
        StringBuilder name = new StringBuilder();
        StringBuilder gender = new StringBuilder();
        StringBuilder profile = new StringBuilder();
        Field[] fields = clazz.getDeclaredFields();


        for (Field field : fields) {
            if (field.isAnnotationPresent(Name.class)) {
                Name arg0 = field.getAnnotation(Name.class);
                name.append(arg0.value());
                log.info("name = "+name);
            }
            if(field.isAnnotationPresent(Gender.class)){
                Gender arg0 = field.getAnnotation(Gender.class);
                gender.append(arg0.gender().toString());
                log.info("gender= " + gender);
            }
            if(field.isAnnotationPresent(Profile.class)){
                Profile arg0 = field.getAnnotation(Profile.class);
                profile.append("[id=").append(arg0.id()).append(",height=").append(arg0.height()).append(",nativePlace=").append(arg0.nativePlace()).append("]");
                log.info("profile="+profile);
            }
        }
    }
}
