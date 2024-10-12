package com.redis.cache.controller;

import com.redis.cache.dto.StudentRequestDTO;
import com.redis.cache.dto.TransactionDTO;
import com.redis.cache.producer.ProducerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("transaction")
@RestController
public class TransactionController {

    private final ProducerService producerService;

    public TransactionController(ProducerService producerService) {
        this.producerService = producerService;
    }


    @PostMapping(value = "sendBroker")
    ResponseEntity<?> sendBroker(@RequestBody TransactionDTO transactionDTO) {
        return ResponseEntity.ok().body(producerService.sendMensage(transactionDTO));
    }
}
