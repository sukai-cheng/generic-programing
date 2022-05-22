package sukai.desginpattern.proxypattern.caseII;

import lombok.Data;

/**
 * @description duck
 *
 * @author chengsukai
 *
 * @create 2022-05-05 13:25
 **/

@Data
public abstract class Duck {

    public FlyBehavior flyBehavior;

    public QuackBehavior quackBehavior;

    public void performFly(){
        flyBehavior.fly();
    }

    public void performQuack(){
        quackBehavior.quack();
    }

}