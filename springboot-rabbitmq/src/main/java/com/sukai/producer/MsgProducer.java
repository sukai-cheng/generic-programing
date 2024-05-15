//package com.sukai.producer;
//
//import com.sukai.config.RabbitConfig;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.amqp.rabbit.support.CorrelationData;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.UUID;
//
///**
// * @author chengsukai
// */
//@Slf4j
//@Component
//public class MsgProducer implements RabbitTemplate.ConfirmCallback {
//
//    //由于rabbitTemplate的scope属性设置为ConfigurableBeanFactory.SCOPE_PROTOTYPE，所以不能自动注入
//    private final RabbitTemplate rabbitTemplate;
//
//    /**
//     * 构造方法注入rabbitTemplate
//     */
//    @Autowired
//    public MsgProducer(RabbitTemplate rabbitTemplate) {
//        this.rabbitTemplate = rabbitTemplate;
//        rabbitTemplate.setConfirmCallback(this); //rabbitTemplate如果为单例的话，那回调就是最后设置的内容
//    }
//
//    /**
//     * 发送消息方法一个交换机配一个路由配一个队列
//     */
//    public void sendMsg(String content) {
//        CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
//        //把消息放入ROUTINGKEY_A对应的队列当中去，对应的是队列A
//        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_A, RabbitConfig.ROUTINGKEY_A, content, correlationId);
//        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_B, RabbitConfig.ROUTINGKEY_B, content, correlationId);
//    }
//
//    /**
//     * 广播模式
//     */
//    public void sendAll(String content) {
//        rabbitTemplate.convertAndSend("fanoutExchange", "", content);
//    }
//
//
//    @Override
//    public void confirm(CorrelationData correlationData, boolean b) {
//
//    }
//}
