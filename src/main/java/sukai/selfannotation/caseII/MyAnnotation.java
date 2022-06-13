package sukai.selfannotation.caseII;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    String value() default "no description";
    int num();
}
