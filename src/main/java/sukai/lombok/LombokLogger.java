package sukai.lombok;

import lombok.extern.slf4j.Slf4j;

/**
 * @author csk
 */
@Slf4j
public class LombokLogger {

    public static void main(String[] args) {

        String name = "csk";

        log.info("我的名字是：{}", name);

    }
}
