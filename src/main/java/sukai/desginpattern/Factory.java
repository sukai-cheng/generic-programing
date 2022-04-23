package sukai.desginpattern;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @description
 *
 * @author chengsukai
 *
 * @create 2022-04-17 21:44
 **/

public class Factory {

    private final static Map<String, Handler> strangeMap = new HashMap<>();

    public static Handler getInvokeStrategy(String name){
        return strangeMap.get(name);
    }

    public static void register(String name, Handler handler){
        if(StringUtils.isEmpty(name) || null == handler){
            return;
        }

        strangeMap.put(name,handler);
    }
}