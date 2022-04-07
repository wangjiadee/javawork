package org.ralph.rabbitmq.Listner;

import org.ralph.rabbitmq.config.RabbitMqConfig;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author ralph
 * @create 2022-04-06 23:16
 */
@Component
public class RabbitMqListener {
    /**
     * define method about listener message
     * queues = <listener queue name>
     * @param message message
     */
    @RabbitListener(queues = RabbitMqConfig.QUEUE_NAME)
    public void listenerQueue(Message message){
        System.out.println("message:"+ message);
    }

}
