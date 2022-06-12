package sukai.selfannotation.caseI;

import lombok.Data;

@Data
public class Person {

    @Name("承苏凯")
    private String name;

    @Gender(gender = Gender.GenderType.Male)
    private String gender;

    @Profile(id = 1001, height = 180, nativePlace = "CN")
    private String profile;
}
