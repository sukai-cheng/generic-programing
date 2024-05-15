//package com.sukai.controller;
//
//import com.sukai.producer.MsgProducer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * @author chengsukai
// */
//@RestController
//public class SendController {
//    @Autowired
//    private MsgProducer msgProducer;
//
//    @RequestMapping(value = "/send", method = RequestMethod.GET)
//    public void send(int length) {
//        for (int i = 1; i <= length; i++) {
//            msgProducer.sendMsg("这是我发送的第" + i + "个信息");
//        }
//    }
//
//    @RequestMapping(value = "/sendAll", method = RequestMethod.GET)
//    public void sendAll(int length) {
//        for (int i = 1; i <= length; i++) {
//            msgProducer.sendAll("这是我发送的第" + i + "个信息");
//        }
//    }
//
//}
