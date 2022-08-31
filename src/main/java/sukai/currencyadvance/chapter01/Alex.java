package sukai.currencyadvance.chapter01;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * 原子性地更新对象的int类型属性， 该属性无须声明成AtomicInteger
 *
 * @author chengsukai
 * @since 2022-08-30 17:21
 */
public class Alex {
    volatile int salary;

    public int getSalary() {
        return this.salary;
    }

    public static void main(String[] args) {

        // 定义AtomicIntegerFieldUpdater，通过newUpdater方法创建
        AtomicIntegerFieldUpdater<Alex> updater =
                AtomicIntegerFieldUpdater.newUpdater(Alex.class, "salary");

        Alex alex = new Alex();
        int result = updater.addAndGet(alex, 1);
        assert result == 1;
    }
}
