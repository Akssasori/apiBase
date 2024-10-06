package com.redis.cache.producer;

import com.redis.cache.dto.StudentRequestDTO;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

    @Value("${rabbit.config.exchange}")
    private String exchenge;

    @Value("${rabbit.config.routing}")
    private String routing_key;

    private final RabbitTemplate rabbitTemplate;

    public ProducerService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public String sendMensage(StudentRequestDTO studentRequestDTO) {
        try {
            rabbitTemplate.convertAndSend(exchenge,routing_key,studentRequestDTO);
        } catch (AmqpException e) {
            throw new RuntimeException(e);
        }

        return "sent with success";
    }
}
