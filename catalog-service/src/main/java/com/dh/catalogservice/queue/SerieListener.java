package com.dh.catalogservice.queue;

import com.dh.catalogservice.model.Serie;
import com.dh.catalogservice.repository.SerieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SerieListener {

    private final SerieRepository serieRepository;

    @RabbitListener(queues = {"${queue.serie.name}"})
    public void receive(@Payload Serie serie) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        serieRepository.save(serie);
    }
    }