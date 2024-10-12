package com.redis.cache.producer;

import com.redis.cache.dto.TransactionDTO;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

    @Value("${rabbit.config.exchange.shopping}")
    private String exchange;

    @Value("${rabbit.config.routing.shopping}")
    private String routing_key;

    private final RabbitTemplate rabbitTemplate;

    public ProducerService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public String sendMensage(TransactionDTO transactionDTO) {
        try {

            rabbitTemplate.convertAndSend(exchange,routing_key,transactionDTO);
        } catch (AmqpException e) {
            throw new RuntimeException(e);
        }

        return "sent with success";
    }
}
