package com.dh.catalogservice.service.Impl;

import com.dh.catalogservice.Feign.IMovieClient;
import com.dh.catalogservice.model.Genre;
import com.dh.catalogservice.model.Movie;
import com.dh.catalogservice.service.CatalogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CatalogServiceImpl implements CatalogService {

    private final IMovieClient iMovieClient;

    @Override
    public List<Movie> getMoviesByGenre(String genre) {
        return   iMovieClient.getMovieByGenre(genre);
    }

    @Override
    public Movie saveMovie(Movie movie) {
        return iMovieClient.saveMovie(movie);
    }

    @Override
    public Genre findByGenre(String genre) {
        return null;
    }
}
