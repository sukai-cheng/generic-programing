package sukai.currencyadvance.chapter08;

/**
 * @author chengsukai
 * @since 2022-09-07 09:50
 */
public interface Computable <A,V>{

    V compute(A arg) throws InterruptedException;
}
