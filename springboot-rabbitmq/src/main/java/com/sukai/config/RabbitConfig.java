package com.sukai.config;


import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author chengsukai
 */
@Configuration
public class RabbitConfig {
    @Value("${spring.rabbitmq.host}")
    private String host;

    @Value("${spring.rabbitmq.port}")
    private int port;

    @Value("${spring.rabbitmq.username}")
    private String username;

    @Value("${spring.rabbitmq.password}")
    private String password;

    public static final String FANOUT_EXCHANGE = "fanoutExchange";

    //交换机
    public static final String EXCHANGE_A = "my-mq-exchange_A";
    public static final String EXCHANGE_B = "my-mq-exchange_B";
    public static final String EXCHANGE_C = "my-mq-exchange_C";
    //队列
    public static final String QUEUE_A = "QUEUE_A";
    public static final String QUEUE_B = "QUEUE_B";
    public static final String QUEUE_C = "QUEUE_C";
    //路由关键字 key
    public static final String ROUTINGKEY_A = "spring-boot-routingKey_A";
    public static final String ROUTINGKEY_B = "spring-boot-routingKey_B";
    public static final String ROUTINGKEY_C = "spring-boot-routingKey_C";

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory(host, port);
        connectionFactory.setUsername(username);
        connectionFactory.setPassword(password);
        //connectionFactory.setVirtualHost("/test");
        connectionFactory.setPublisherConfirmType(CachingConnectionFactory.ConfirmType.CORRELATED);
        return connectionFactory;
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    //必须是prototype类型
    public RabbitTemplate rabbitTemplate() {
        return new RabbitTemplate(connectionFactory());
    }

    /**
     * 针对消费者配置
     * 1. 设置交换机类型
     * 2. 将队列绑定到交换机
     * FanoutExchange: 将消息分发到所有的绑定队列，无routingkey的概念
     * HeadersExchange ：通过添加属性key-value匹配
     * DirectExchange:按照routingkey分发到指定队列
     * TopicExchange:多关键字匹配
     */
    @Bean
    public DirectExchange defaultExchangeA() {
        return new DirectExchange(EXCHANGE_A);
    }

    @Bean
    public DirectExchange defaultExchangeB() {
        return new DirectExchange(EXCHANGE_B);
    }

    @Bean
    public DirectExchange directExchangeC() {
        return new DirectExchange(EXCHANGE_C);
    }

    /**
     * 获取队列A
     */
    @Bean
    public Queue queueA() {
        return new Queue(QUEUE_A, true); //队列持久
    }

    @Bean
    public Queue queueB() {
        return new Queue(QUEUE_B, true); //队列持久
    }

    @Bean
    public Queue queueC() {
        return new Queue(QUEUE_C, true); //队列持久
    }

    /**
     * 队列绑定交换机
     */
    @Bean
    public org.springframework.amqp.core.Binding bindingA() {
        return BindingBuilder.bind(queueA()).to(defaultExchangeA()).with(RabbitConfig.ROUTINGKEY_A);
    }

    @Bean
    public Binding bindingB() {
        return BindingBuilder.bind(queueB()).to(defaultExchangeB()).with(RabbitConfig.ROUTINGKEY_B);
    }

    @Bean
    public Binding bindingC() {
        return BindingBuilder.bind(queueC()).to(directExchangeC()).with(RabbitConfig.ROUTINGKEY_C);
    }

    //配置fanout_exchange
    //fanout只能支持统一广播
    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange(RabbitConfig.FANOUT_EXCHANGE);
    }

    //把所有的队列都绑定到这个交换机上去
    @Bean
    Binding bindingExchangeA(FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(queueA()).to(fanoutExchange);
    }

    @Bean
    Binding bindingExchangeB(FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(queueB()).to(fanoutExchange);
    }

    @Bean
    Binding bindingExchangeC(FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(queueC()).to(fanoutExchange);
    }

}
