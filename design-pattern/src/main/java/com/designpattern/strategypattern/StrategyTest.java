package com.designpattern.strategypattern;

import java.util.HashMap;

public class StrategyTest {
    public static void main(String[] args) {

//        try{
//            Strategy strategy = initMap("man");
//            strategy.run();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
        try{
            com.designpattern.strategypattern.refactor.Strategy strategy = com.designpattern.strategypattern.refactor.Strategy.MAN;
            strategy.run();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 建议使用枚举类优化
     */
    private static Strategy initMap(String key){
        HashMap<String,Strategy> map = new HashMap<>();
        map.put("man",new ManStrategy());
        map.put("woman",new WomanStrategy());
        map.put("other",new OtherStrategy());
        return map.get(key);
    }
}
