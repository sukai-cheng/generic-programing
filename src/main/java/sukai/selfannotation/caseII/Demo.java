package sukai.selfannotation.caseII;

@MyAnnotation(value = "annotation on class", num = 0)
public class Demo {

    @MyAnnotation(value = "annotation on field", num = 1)
    public String name;

    @MyAnnotation(value = "annotation on method", num = 2)
    public void hello() {
    }

    @MyAnnotation(num = 3)
    public void defaultMethod() {
    }

}
