package sukai.functional.lambda.caseIII;

/**
 * @author chengsukai
 * @since 2022-07-25 13:48
 */
public class PointWrapper implements Consumer<Point>{
    @Override
    public void accept(Point point) {
        point.doSomething();
    }
}
