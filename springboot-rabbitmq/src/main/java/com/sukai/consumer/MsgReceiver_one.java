package com.sukai.consumer;

import com.sukai.config.RabbitConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RabbitListener(queues = RabbitConfig.QUEUE_A)
public class MsgReceiver_one {

    @RabbitHandler
    public void process(String content) {
        log.info("消费者one接收处理队列A当中的消息： " + content);
    }
}
