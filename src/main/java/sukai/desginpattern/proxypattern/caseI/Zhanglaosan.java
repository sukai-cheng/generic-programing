package sukai.desginpattern.proxypattern.caseI;

/**
 * @description
 *
 * @author chengsukai
 *
 * @create 2022-05-04 13:56
 **/
public class Zhanglaosan implements IPerson{

    private Zhangsan zhangsan;

    public Zhanglaosan() {
    }

    public Zhanglaosan(Zhangsan zhangsan) {
        this.zhangsan = zhangsan;
    }

    @Override
    public void findTeacher() {
        System.out.println("张老三开始找老师");
        zhangsan.findTeacher();
        System.out.println("开始学习");
    }
}