package sukai.currencyBasic.chapter19;

/**
 * @author chengsukai
 * @since 2022-08-29 15:10
 */
@FunctionalInterface
public interface Task<IN, OUT> {

    OUT get(IN input);
}
