package sukai.currency.chapter13;

/**
 * @author chengsukai
 * @since 2022-08-26 15:54
 */
public class ReadWriteLockImpl implements ReadWriteLock {

    private final Object MUTEX = new Object();

    private int writingWriters = 0;

    private int writingWaiters = 0;

    private int readingReaders = 0;

    private int readingWaiters = 0;

    private boolean preferWriter;

    public Object getMUTEX() {
        return MUTEX;
    }

    boolean getPreferWriter() {
        return this.preferWriter;
    }

    void changePrefer(boolean preferWriter) {
        this.preferWriter = preferWriter;
    }

    public ReadWriteLockImpl() {
        this(true);
    }

    public ReadWriteLockImpl(boolean preferWriter) {
        this.preferWriter = true;
    }


    @Override
    public Lock readLock() {
        return new ReadLock(this);
    }

    @Override
    public Lock writeLock() {
        return new WriteLock(this);
    }

    @Override
    public int getWritingWriters() {
        return writingWriters;
    }

    @Override
    public int getReadingReaders() {
        return readingReaders;
    }

    public void setWritingWriters(int writingWriters) {
        this.writingWriters = writingWriters;
    }

    public int getWritingWaiters() {
        return writingWaiters;
    }

    public void setWritingWaiters(int writingWaiters) {
        this.writingWaiters = writingWaiters;
    }

    public void setReadingReaders(int readingReaders) {
        this.readingReaders = readingReaders;
    }

    public int getReadingWaiters() {
        return readingWaiters;
    }

    public void setReadingWaiters(int readingWaiters) {
        this.readingWaiters = readingWaiters;
    }

    public boolean isPreferWriter() {
        return preferWriter;
    }

    public void setPreferWriter(boolean preferWriter) {
        this.preferWriter = preferWriter;
    }

    void incrementWritingWriters() {
        this.writingWriters++;
    }

    void incrementWaitingWriters() {
        this.writingWriters++;
    }

    void incrementReadingReaders() {
        this.readingReaders++;
    }

    void incrementReadingWaiters() {
        this.readingWaiters++;
    }

    void decrementWritingWriters() {
        this.writingWriters--;
    }

    void decrementWritingWaiters() {
        this.writingWaiters--;
    }

    void decrementReadingReaders() {
        this.readingReaders--;
    }

    void decrementReadingWaiters() {
        this.readingWaiters--;
    }
}
