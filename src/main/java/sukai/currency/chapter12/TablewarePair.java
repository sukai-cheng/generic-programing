package sukai.currency.chapter12;

/**
 * @author chengsukai
 * @since 2022-08-26 15:31
 */
public class TablewarePair {
    private final Tableware leftTool;
    private final Tableware rightTool;

    public TablewarePair(Tableware leftTool, Tableware rightTool) {
        this.leftTool = leftTool;
        this.rightTool = rightTool;
    }

    public Tableware getLeftTool(){
        return leftTool;
    }

    public Tableware getRightTool(){
        return rightTool;
    }
}