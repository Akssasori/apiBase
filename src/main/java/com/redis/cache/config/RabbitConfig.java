package com.redis.cache.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {


    @Value("${rabbit.config.exchange}")
    private String exchenge;

    @Value("${rabbit.config.routing}")
    private String routing_key;

    @Value("${rabbit.config.queue}")
    private String queue;

    @Bean
    public Exchange myExchange() {
        return ExchangeBuilder.topicExchange(exchenge).durable(true).build();
    }

    @Bean
    public Queue createQueues() {
        return QueueBuilder.durable(queue).build();

    }

    @Bean
    public Binding binding(Queue myQueue, Exchange myExchange) {
        return BindingBuilder.bind(myQueue)
                .to(myExchange)
                .with(routing_key)
                .noargs();
    }



}
