package com.example.serieservice.controller;

import com.example.serieservice.model.Serie;
import com.example.serieservice.queue.SerieListener;
import com.example.serieservice.service.SerieService;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author vaninagodoy
 */

@RestController
@RefreshScope
@RequiredArgsConstructor
public class SerieController {

    private final SerieService serieService;
    private final SerieListener serieListener;

    @GetMapping
    public List<Serie> getAll() {
        return serieService.getAll();
    }

    @GetMapping("/series/{genre}")
    public List<Serie> getSerieByGenre(@PathVariable String genre) {
        return serieService.getSeriesBygGenre(genre);
    }

    /*@PostMapping("/series/save")
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@RequestBody Serie serie) {
        serieService.create(serie);
        return serie.getId();
    }*/

    @PostMapping("/series/save")
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@RequestBody Serie serie) {
        serieListener.receive(serie);
        return ResponseEntity.noContent().build().toString();
    }
}
