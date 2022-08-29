package sukai.currency.chapter17;

/**
 * @author chengsukai
 * @since 2022-08-29 10:17
 */
public class Reference {
    private final byte[] data = new byte[2 << 19];

    @Override
    protected void finalize() throws Throwable {
        System.out.println("the reference will be GC.");
    }
}
