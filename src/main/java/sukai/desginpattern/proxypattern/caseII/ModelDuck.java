package sukai.desginpattern.proxypattern.caseII;

/**
 * @description
 *
 * @author chengsukai
 *
 * @create 2022-05-05 13:43
 **/
public class ModelDuck extends Duck {

    public ModelDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new Quack();
    }

    public void display() {
        System.out.println("I'm a model duck");
    }


}