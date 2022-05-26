package sukai.proxy;

import org.springframework.stereotype.Component;

/**
 * @description
 *
 * @author chengsukai
 *
 * @create 2022-04-17 22:47
 **/

@Component
public class BHandler extends Handler{
    @Override
    public void BBB() {
        System.out.println("xxx");
    }

    @Override
    public void afterPropertiesSet() {
        Factory.register("xxx",this);
    }
}