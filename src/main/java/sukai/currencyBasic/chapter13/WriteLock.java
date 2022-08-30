package sukai.currencyBasic.chapter13;

/**
 * @author chengsukai
 * @since 2022-08-26 15:59
 */
public class WriteLock implements Lock {

    private final ReadWriteLockImpl readWriteLock;

    WriteLock(ReadWriteLockImpl readWriteLock) {
        this.readWriteLock = readWriteLock;
    }

    @Override
    public void lock() throws InterruptedException {
        synchronized (readWriteLock.getMUTEX()) {
            try {
                readWriteLock.incrementWaitingWriters();
                while (readWriteLock.getReadingReaders() > 0 || readWriteLock.getWritingWriters() > 0) {
                    readWriteLock.getMUTEX().wait();
                }
            } finally {
                this.readWriteLock.decrementWritingWaiters();
            }
            readWriteLock.incrementWritingWriters();
        }
    }

    @Override
    public void unlock() {
        synchronized (readWriteLock.getMUTEX()) {
            readWriteLock.decrementWritingWriters();
            readWriteLock.changePrefer(false);
            readWriteLock.getMUTEX().notifyAll();
        }
    }
}
