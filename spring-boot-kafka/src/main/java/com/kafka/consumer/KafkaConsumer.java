package com.kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaConsumer {

    /**
     * @KafkaListener 指定需要监听的 topic 和 groupId
     * topics 是一个数组 如：topics = {"kafka1", "kafka2}
     * @param message 消息
     */
    @KafkaListener(topics = "kafka", groupId = "group_id")
    public void consume(String message) {
        log.info("## consume message: {}", message);
    }
}
