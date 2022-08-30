package sukai.currencyadvance.chapter01;

import lombok.Data;

/**
 * @author chengsukai
 * @since 2022-08-30 15:10
 */
@Data
public class DebitCard {
    private final String account;
    private final int amount;

    public DebitCard(String account, int amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "DebitCard{" +
                "account='" + account + '\'' +
                ", amount=" + amount +
                '}';
    }
}
