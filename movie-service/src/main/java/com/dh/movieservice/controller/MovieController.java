package com.dh.movieservice.controller;

import com.dh.movieservice.model.Movie;
import com.dh.movieservice.service.impl.MovieService;
import org.apache.http.HttpServerConnection;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author vaninagodoy
 */

@RestController

public class MovieController {

    private final MovieService movieService;


    @Value("${server.port}")
    private int serverPort;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies/{genre}")
    ResponseEntity<List<Movie>> getMovieByGenre(@PathVariable String genre, HttpServletResponse response) {
        response.addHeader("port", String.valueOf(serverPort));
        System.out.println("Puerto utilizado: " + response.getHeaders("port"));
        return ResponseEntity.ok().body(movieService.findByGenre(genre));
    }

    @PostMapping("/movies/save")
    ResponseEntity<Movie> saveMovie(@RequestBody Movie movie) {
        return ResponseEntity.ok().body(movieService.save(movie));
    }
}
