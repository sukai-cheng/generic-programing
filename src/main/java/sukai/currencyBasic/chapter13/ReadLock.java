package sukai.currencyBasic.chapter13;

/**
 * @author chengsukai
 * @since 2022-08-26 15:57
 */
public class ReadLock implements Lock {

    private final ReadWriteLockImpl readWriteLock;

    public ReadLock(ReadWriteLockImpl readWriteLock) {
        this.readWriteLock = readWriteLock;
    }

    @Override
    public void lock() throws InterruptedException {
        synchronized (readWriteLock.getMUTEX()) {
            while (readWriteLock.getWritingWriters() > 0
                    || (readWriteLock.getPreferWriter() && readWriteLock.getWritingWaiters() > 0)) {
                readWriteLock.getMUTEX().wait();
            }
            readWriteLock.incrementReadingReaders();
        }
    }

    @Override
    public void unlock() {
        synchronized (readWriteLock.getMUTEX()) {
            readWriteLock.decrementReadingReaders();
            readWriteLock.changePrefer(true);
            readWriteLock.getMUTEX().notifyAll();
        }
    }

}
