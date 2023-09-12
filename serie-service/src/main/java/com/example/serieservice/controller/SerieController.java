package com.example.serieservice.controller;

import com.example.serieservice.model.Serie;
import com.example.serieservice.queue.SerieSender;
import com.example.serieservice.service.SerieService;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.context.config.annotation.RefreshScope;
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

    private final SerieSender serieSender;


    @GetMapping("/series/{genre}")
    public List<Serie> getSerieByGenre(@PathVariable String genre) {
        return serieService.getSeriesBygGenre(genre);
    }

    @PostMapping("/series/save")
    public ResponseEntity<String> createSerie(@RequestBody Serie serie){
        serieSender.send(serie);
        return ResponseEntity.ok(serieService.create(serie));
    }
}
