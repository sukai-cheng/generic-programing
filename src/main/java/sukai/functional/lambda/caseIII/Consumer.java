package sukai.functional.lambda.caseIII;

/**
 * @author chengsukai
 * @since 2022-07-25 13:47
 * SAM接口 - 公开单个抽象方法
 */
public interface Consumer<T> {
    void accept(T t);
}
