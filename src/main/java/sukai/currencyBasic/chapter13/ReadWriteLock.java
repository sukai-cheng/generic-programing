package sukai.currencyBasic.chapter13;

/**
 * @author chengsukai
 * @since 2022-08-26 15:52
 */
public interface ReadWriteLock {
    Lock readLock();

    Lock writeLock();

    int getWritingWriters();

    int getReadingReaders();


    static ReadWriteLock readWriteLock() {
        return new ReadWriteLockImpl();
    }

    static ReadWriteLock readWriteLock(boolean preferWriter) {
        return new ReadWriteLockImpl(preferWriter);
    }


}
