package sukai.currencyBasic.chapter12;

/**
 * @author chengsukai
 * @since 2022-08-26 14:56
 */
public class FlightSecurity {
    private int count = 0;
    private String boardingPass = "null";
    private String idCard = "null";

    public synchronized void pass(String boardingPass, String idCard) {
        this.boardingPass = boardingPass;
        this.idCard = idCard;
        this.count++;
        check(); // 因为check是在同步方法下面执行的， pass方法已经保证了single thread execution
    }


    private void check() {
        if (boardingPass.charAt(0) != idCard.charAt(0)) {
            throw new RuntimeException("====Exception====" + toString());
        }
    }

    public String toString() {
        return "The " + count + " passengers,boardingPass [" + boardingPass + " ],idCard [" + idCard + "]";
    }

}
