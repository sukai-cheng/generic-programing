package com.designpattern.proxypattern.caseIV;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chengsukai
 */
public class AlipayTransaction implements Transaction {
    @Override
    public Map<String, String> pay(Map<String, String> params) {
        System.out.println("封装支付宝支付参数");
        System.out.println("调用支付宝支付接口");
        Map<String, String> result = new HashMap<>();
        System.out.println("封装支付宝响应的支付结果");
        return result;
    }
}
