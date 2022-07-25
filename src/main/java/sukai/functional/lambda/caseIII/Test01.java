package sukai.functional.lambda.caseIII;

/**
 * @author chengsukai
 * @since 2022-07-25 13:40
 */
public class Test01 {
    public static void main(String[] args) {
        Point p = new Point();
        PointWrapper pointWrapper = new PointWrapper();
        pointWrapper.accept(p);
    }
}
