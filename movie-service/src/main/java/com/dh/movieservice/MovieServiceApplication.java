package com.dh.movieservice;

import com.dh.movieservice.model.Movie;
import com.dh.movieservice.repository.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class MovieServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData(MovieRepository repository) {
        return (args) -> {
            if (!repository.findAll().isEmpty()) {
                return;
            }

            repository.save(new Movie(null, "Pelicula 1", "Terror", "www.netflix.com"));
            repository.save(new Movie(null, "Pelicula 2", "Terror", "www.netflix.com"));
            repository.save(new Movie(null, "Pelicula 3", "Comedia", "www.netflix.com"));
            repository.save(new Movie(null, "Pelicula 4", "Ficcion", "www.netflix.com"));
        };
    }
}
