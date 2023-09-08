package com.dh.catalogservice.service.Impl;

import com.dh.catalogservice.Feign.IMovieClient;
import com.dh.catalogservice.Feign.ISerieClient;
import com.dh.catalogservice.model.Movie;
import com.dh.catalogservice.model.Serie;
import com.dh.catalogservice.service.CatalogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService {

    private final IMovieClient iMovieClient;

    private final ISerieClient iSerieClient;

    public CatalogServiceImpl(IMovieClient iMovieClient, ISerieClient iSerieClient) {
        this.iMovieClient = iMovieClient;
        this.iSerieClient = iSerieClient;
    }

    @Override
    public List<Movie> getMoviesByGenre(String genre) {
        return   iMovieClient.getMovieByGenre(genre);
    }

    @Override
    public Movie saveMovie(Movie movie) {
        return iMovieClient.saveMovie(movie);
    }

    @Override
    public String create(Serie serie) {
        iSerieClient.create(serie);
        return serie.getId();
    }
    @Override
    public List<Serie> getSeriesBygGenre(String genre) {
        return iSerieClient.getSeriesBygGenre(genre);
    }

}
