package sukai.proxy;

import org.springframework.stereotype.Component;

/**
 * @description
 *
 * @author chengsukai
 *
 * @create 2022-04-17 21:57
 **/
@Component
public class AHandler extends Handler{

    @Override
    public void AAA(String name) {
        System.out.println("My name is " + name);
    }

    @Override
    public void afterPropertiesSet() {
        Factory.register("csk",this);
    }
}