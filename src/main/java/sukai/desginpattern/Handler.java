package sukai.desginpattern;

import org.springframework.beans.factory.InitializingBean;

/**
 * @description
 *
 * @author chengsukai
 *
 * @create 2022-04-17 21:40
 **/
public abstract class Handler implements InitializingBean {

    public void AAA(String name){
        throw new UnsupportedOperationException();
    }

    public void BBB(){
        throw new UnsupportedOperationException();
    }
}
