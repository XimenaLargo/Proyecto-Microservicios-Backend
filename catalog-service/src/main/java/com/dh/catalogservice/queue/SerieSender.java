package com.dh.catalogservice.queue;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;
import com.dh.catalogservice.model.Serie;

@Component
@RequiredArgsConstructor
public class SerieSender {

        private final RabbitTemplate rabbitTemplate;
        private final Queue serieQueue;

        public void send(Serie serie){
            this.rabbitTemplate.convertAndSend(this.serieQueue.getName(), serie);
        }
}
