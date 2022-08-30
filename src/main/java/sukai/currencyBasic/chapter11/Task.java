package sukai.currencyBasic.chapter11;

/**
 * @author chengsukai
 * @since 2022-08-26 11:14
 */
@FunctionalInterface
public interface Task<IN,OUT> {
    OUT get(IN input);
}
