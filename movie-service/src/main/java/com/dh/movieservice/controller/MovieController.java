package com.dh.movieservice.controller;

import com.dh.movieservice.model.Movie;
import com.dh.movieservice.queue.MovieListener;
import com.dh.movieservice.service.impl.MovieService;
import lombok.RequiredArgsConstructor;
import org.apache.http.HttpServerConnection;
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

    private final MovieListener movieListener;

    @Value("${server.port}")
    private int serverPort;

   @GetMapping("/movies/{genre}")
    ResponseEntity<List<Movie>> getMovieByGenre(@PathVariable String genre, HttpServletResponse response) {
        response.addHeader("port-movie", String.valueOf(serverPort));
        System.out.println("Puerto utilizado: " + response.getHeaders("port-movie"));
        return ResponseEntity.ok().body(movieService.findByGenre(genre));
    }

   /* @PostMapping("/movies/save")
    ResponseEntity<Movie> saveMovie(@RequestBody Movie movie) {
        return ResponseEntity.ok().body(movieService.save(movie));
    }*/

    @PostMapping("/movies/save")
    ResponseEntity<Movie> saveMovie(@RequestBody Movie movie) {
        movieListener.receive(movie);
        return ResponseEntity.noContent().build();
    }
}
