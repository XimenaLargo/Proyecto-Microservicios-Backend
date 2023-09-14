package com.dh.catalogservice.queue;

import com.dh.catalogservice.model.Movie;
import com.dh.catalogservice.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MovieListener {

    private final MovieRepository movieRepository;

    @RabbitListener(queues = {"${queue.movie.name}"})
    public void receive(@Payload Movie movie) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       movieRepository.save(movie);
    }
    }
