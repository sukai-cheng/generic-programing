package sukai.selfannotation.caseI;

import java.lang.annotation.*;

@Target(ElementType.FIELD) // 用于描述域
@Retention(RetentionPolicy.RUNTIME) // 可以通过反射获取该注解的属性
@Documented // 可以被javadoc此类工具文档化
public @interface Name {
    String value() default "";
}
