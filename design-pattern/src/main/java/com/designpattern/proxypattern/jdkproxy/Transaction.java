package com.designpattern.proxypattern.jdkproxy;

import java.util.Map;

/**
 * @author chengsukai
 */
public interface Transaction {
    Map<String, String> pay(Map<String,String> params);
}
