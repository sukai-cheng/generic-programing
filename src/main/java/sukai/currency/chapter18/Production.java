package sukai.currency.chapter18;

/**
 * @author chengsukai
 * @since 2022-08-29 13:55
 */
public class Production extends InstructionBook {

    private final int prodID;

    public Production(int prodID) {
        this.prodID = prodID;
    }

    @Override
    protected void firstProcess() {
        System.out.println("execute the " + prodID + " first process.");
    }

    @Override
    protected void secondProcess() {
        System.out.println("execute the " + prodID + " second process.");
    }
}
