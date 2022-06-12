package sukai.selfannotation.caseI;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Gender {

    enum GenderType {
        Male("男"),
        Female("女"),
        Other("中性");

        private final String genderStr;

        GenderType(String arg0){
            this.genderStr = arg0;
        }

        @Override
        public String toString() {
            return "GenderType{" +
                    "genderStr='" + genderStr + '\'' +
                    '}';
        }

    }

    GenderType gender() default GenderType.Female;
}
