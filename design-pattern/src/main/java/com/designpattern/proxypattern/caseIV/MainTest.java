package com.designpattern.proxypattern.caseIV;

import java.util.HashMap;

/**
 * @author chengsukai
 */
public class MainTest {

    public static void main(String[] args) throws Exception {

        ProxyAlipayTransaction proxyAlipayTransaction = new ProxyAlipayTransaction();

        Transaction obj = (Transaction) proxyAlipayTransaction.getInstance(new AlipayTransaction());

        System.out.println(obj.getClass());

        obj.pay(new HashMap<>());

    }


}
