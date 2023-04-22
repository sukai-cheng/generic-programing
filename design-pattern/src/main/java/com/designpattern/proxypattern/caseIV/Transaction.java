package com.designpattern.proxypattern.caseIV;

import java.util.Map;

/**
 * @author chengsukai
 */
public interface Transaction {
    Map<String, String> pay(Map<String,String> params);
}
