package org.ralph.rabbitmq.controller;

import lombok.extern.slf4j.Slf4j;
import org.ralph.rabbitmq.config.RabbitMqConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ralph
 * @create 2022-04-06 23:05
 */
@Slf4j
@RestController
public class RabbitMqProducerController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/api/sendMessage")
    public void send(){
        rabbitTemplate.convertAndSend(RabbitMqConfig.EXCHANGE_NAME,"springboot.ralph","springboot send mq");
        log.info("send message success!");
    }


}
