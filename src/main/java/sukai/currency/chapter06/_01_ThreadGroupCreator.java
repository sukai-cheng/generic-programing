package sukai.currency.chapter06;

/**
 * @author chengsukai
 * @since 2022-08-22 14:12
 */
public class _01_ThreadGroupCreator {
    public static void main(String[] args) {

        ThreadGroup currentGroup = Thread.currentThread().getThreadGroup();

        ThreadGroup group1 = new ThreadGroup("Group1");

        System.out.println(group1.getParent() == currentGroup); // 没有指定父group，则当前线程所在的Group1

        ThreadGroup group2 = new ThreadGroup(group1, "Group2");// 指定group1为父group

        System.out.println(group2.getParent() == group1);

    }
}
