package com.dh.catalogservice.Controller;

import com.dh.catalogservice.Feign.IMovieClient;
import com.dh.catalogservice.model.Movie;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CatalogController {

    private final IMovieClient iMovieClient;

    public CatalogController(IMovieClient iMovieClient) {
        this.iMovieClient = iMovieClient;
    }


    @GetMapping("/catalog/{genre}")
    public ResponseEntity<List<Movie>> getMovieByGenre(@PathVariable  String genre){
        return ResponseEntity.ok( iMovieClient.getMovieByGenre(genre));
    }

    @PostMapping("/catalog/save")
    public ResponseEntity<Movie> saveMovie(@RequestBody  Movie movie){
        return ResponseEntity.ok(iMovieClient.saveMovie(movie));
    }
}
