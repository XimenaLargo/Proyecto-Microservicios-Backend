package com.dh.catalogservice.service.Impl;

import com.dh.catalogservice.Feign.IMovieClient;
import com.dh.catalogservice.Feign.ISerieClient;
import com.dh.catalogservice.model.Genre;
import com.dh.catalogservice.model.Movie;
import com.dh.catalogservice.model.Serie;
import com.dh.catalogservice.repository.MovieRepository;
import com.dh.catalogservice.repository.SerieRepository;
import com.dh.catalogservice.service.CatalogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CatalogServiceImpl implements CatalogService {


    private final IMovieClient iMovieClient;

    private final ISerieClient iSerieClient;

    private final MovieRepository movieRepository;

    private final SerieRepository serieRepository;


    @Override
    public Genre getAllByGenre(String genre) {
        return new Genre(movieRepository.findAllMoviesByGenre(genre), serieRepository.findAllSeriesByGenre(genre));
    }

    @Override
    public void saveMovie(Movie movie) {
        iMovieClient.saveMovie(movie);
    }

    @Override
    public void saveSerie(Serie serie) {
        iSerieClient.create(serie);
    }

}
