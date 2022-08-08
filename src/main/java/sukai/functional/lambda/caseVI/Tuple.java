package sukai.functional.lambda.caseVI;

/**
 * 通用类
 * @author chengsukai
 * @since 2022-08-06 14:14
 */
public class Tuple<T, U> {
    public final T _1;
    public final U _2;

    public Tuple(T _1, U _2) {
        this._1 = _1;
        this._2 = _2;
    }
}
