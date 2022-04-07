package org.ralph.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * @author ralph
 * @create 2022-04-06 22:56
 */
@Configuration
public class RabbitMqConfig {

    public static final String  EXCHANGE_NAME = "springboot_topic_exchange";
    public static final String QUEUE_NAME = "springboot_queue";

    /**
     * declare exchanges
     */
    @Bean("bootExchange")
    public Exchange bootExchange(){

        return ExchangeBuilder.topicExchange(EXCHANGE_NAME).durable(true).build();
    }


    /**
     * declare queue
     */
    @Bean("bootQueue")
    public Queue bootQueue(){

        return QueueBuilder.durable(QUEUE_NAME).build();
    }

    /**
     * binding queue and exchange
     * @param queue queue
     * @param exchange exchange
     */
    @Bean
    public Binding bindQueueExchange(@Qualifier("bootQueue") Queue queue, @Qualifier("bootExchange") Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("springboot.#").noargs();
    }


}
