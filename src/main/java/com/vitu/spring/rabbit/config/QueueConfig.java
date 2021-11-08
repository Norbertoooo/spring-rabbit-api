package com.vitu.spring.rabbit.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueueConfig {

    @Value("${queue.pessoa.name}")
    String queueName;

    @Bean
    Queue queue() {
        return new Queue(queueName, false);
    }

}
