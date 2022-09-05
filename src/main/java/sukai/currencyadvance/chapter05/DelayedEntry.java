package sukai.currencyadvance.chapter05;

import lombok.ToString;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author chengsukai
 * @since 2022-09-02 15:02
 */

@ToString
public class DelayedEntry implements Delayed {

    private final String value;
    private final long time;

    public DelayedEntry(String value, long time) {
        this.value = value;
        this.time = time + System.currentTimeMillis();
    }

    @Override
    public long getDelay(@NotNull TimeUnit unit) {
        long delta = time - System.currentTimeMillis();
        return unit.convert(delta, TimeUnit.MILLISECONDS);
    }

    public String getValue() {
        return value;
    }

    @Override
    public int compareTo(@NotNull Delayed o) {

        return Long.compare(this.time, ((DelayedEntry) o).time);
    }

    public static void main(String[] args) throws InterruptedException {

        DelayQueue<DelayedEntry> delayQueue = new DelayQueue<>();
        delayQueue.put(new DelayedEntry("A", 10 * 1000L));
        delayQueue.put(new DelayedEntry("B", 5 * 1000L));
        final long timestamp = System.currentTimeMillis();
        assert delayQueue.poll() == null;
        DelayedEntry value = delayQueue.take();
        assert value.getValue().equals("B");
        assert (System.currentTimeMillis() - timestamp) >= 5_000L;

        value = delayQueue.take();
        assert value.getValue().equals("A");
        assert (System.currentTimeMillis() - timestamp) >= 10_000L;
    }

}
