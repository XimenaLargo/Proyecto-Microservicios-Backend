package com.dh.movieservice.controller;

import com.dh.movieservice.model.Movie;
import com.dh.movieservice.queue.MovieSender;
import com.dh.movieservice.service.impl.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author vaninagodoy
 */
@RefreshScope
@RestController
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;

    private final MovieSender movieSender;

    @Value("${server.port}")
    private int serverPort;

   @GetMapping("/movies/{genre}")
    public ResponseEntity<List<Movie>> getMovieByGenre(@PathVariable String genre, HttpServletResponse response) {
        response.addHeader("port-movie", String.valueOf(serverPort));
        System.out.println("Puerto utilizado: " + response.getHeaders("port-movie"));
        return ResponseEntity.ok().body(movieService.findByGenre(genre));
    }

    @PostMapping("/movies/save")
    public ResponseEntity<Movie> saveMovie(@RequestBody  Movie movie){
        movieSender.send(movie);
        return ResponseEntity.ok(movieService.save(movie));
    }
}
