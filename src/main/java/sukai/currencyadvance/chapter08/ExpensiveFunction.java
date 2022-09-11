package sukai.currencyadvance.chapter08;

import java.math.BigInteger;

/**
 * @author chengsukai
 * @since 2022-09-07 09:51
 */
public class ExpensiveFunction implements Computable<String, BigInteger> {
    @Override
    public BigInteger compute(String arg) throws InterruptedException {
        return new BigInteger(arg);
    }


}
