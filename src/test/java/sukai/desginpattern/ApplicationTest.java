package sukai.desginpattern;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sukai.proxy.Factory;
import sukai.proxy.Handler;

/**
 * @description
 *
 * @author chengsukai
 *
 * @create 2022-04-17 22:00
 **/

@SpringBootTest
@RunWith(SpringRunner.class)
public class ApplicationTest {

    @Test
    public void Design(){

        String name = "csk";

        Handler handler = Factory.getInvokeStrategy(name);

        handler.AAA(name);

        handler = Factory.getInvokeStrategy("xxx");

        handler.BBB();
    }
}