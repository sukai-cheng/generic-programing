package sukai.currencyBasic.chapter18;

/**
 * create是个模板方法
 *
 * @author chengsukai
 * @since 2022-08-29 13:52
 */
public abstract class InstructionBook {
    public final void create() {
        this.firstProcess();
        this.secondProcess();
    }

    protected abstract void firstProcess();

    protected abstract void secondProcess();
}
