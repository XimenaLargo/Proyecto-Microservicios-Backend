package com.dh.movieservice.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQSenderConfig {

    @Value("${queue.movie.name}")
    private String movieQueue;

    @Bean
    public Queue movieQueue() {
        return new Queue(movieQueue, true);
    }

}
