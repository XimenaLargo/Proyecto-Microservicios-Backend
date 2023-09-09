package com.example.serieservice.queue;


import com.example.serieservice.model.Serie;
import com.example.serieservice.service.SerieService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SerieListener {

    private final SerieService serieService;

    @RabbitListener(queues = {"${queue.serie.name}"})
    public void receive(@Payload Serie serie) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        serieService.create(serie);
    }

}
