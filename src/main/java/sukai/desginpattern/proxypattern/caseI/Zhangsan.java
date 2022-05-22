package sukai.desginpattern.proxypattern.caseI;

/**
 * @description
 *
 * @author chengsukai
 *
 * @create 2022-05-04 13:55
 **/
public class Zhangsan implements IPerson{
    @Override
    public void findTeacher() {
        System.out.println("我要补习数学");
    }
}