package com.seckill.config;


import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author chengsukai
 */
@Configuration
public class RabbitConfig {

    @Bean
    public Queue queue() {
        return new Queue("queue", true);
    }

}
