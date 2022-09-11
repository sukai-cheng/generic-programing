package sukai.proxy.caseIII;

/**
 * @author chengsukai
 * @since 2022-09-10 16:01
 */
public class Calculator implements ICalculator {
    @Override
    public Integer add(Integer i, Integer j) {

        Integer result = i + j;
        return result;
    }

    @Override
    public Integer sub(Integer i, Integer j) {
        Integer result = i - j;
        return result;
    }

    @Override
    public Integer mul(Integer i, Integer j) {
        Integer result = i * j;
        return result;
    }

    @Override
    public Integer div(Integer i, Integer j) {
        Integer result = i / j;
        return result;
    }
}
