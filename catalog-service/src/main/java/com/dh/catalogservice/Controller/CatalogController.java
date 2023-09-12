package com.dh.catalogservice.Controller;

import com.dh.catalogservice.model.Genre;
import com.dh.catalogservice.model.Movie;
import com.dh.catalogservice.model.Serie;
import com.dh.catalogservice.queue.MovieListener;
import com.dh.catalogservice.queue.SerieListener;
import com.dh.catalogservice.service.CatalogService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequiredArgsConstructor
public class CatalogController {

    private final CatalogService catalogService;

    private final MovieListener movieListener;

    private final SerieListener serieListener;

    @Value("${server.port}")
    private int serverPort;


    @PostMapping("/catalog/movies/save")
    ResponseEntity<Movie> saveMovie(@RequestBody Movie movie) {
        movieListener.receive(movie);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/catalog/series/save")
    public ResponseEntity<String> createSerie(@RequestBody Serie serie){
        serieListener.receive(serie);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/catalog/{genre}")
    public ResponseEntity<Genre> getAllByGenre(@PathVariable String genre){
        return ResponseEntity.ok(catalogService.getAllByGenre(genre));
    }

}
