package com.dh.catalogservice.service.Impl;

import com.dh.catalogservice.Feign.IMovieClient;
import com.dh.catalogservice.Feign.ISerieClient;
import com.dh.catalogservice.exception.CircuitBreakerException;
import com.dh.catalogservice.model.Genre;
import com.dh.catalogservice.model.Movie;
import com.dh.catalogservice.model.Serie;
import com.dh.catalogservice.repository.MovieRepository;
import com.dh.catalogservice.repository.SerieRepository;
import com.dh.catalogservice.service.CatalogService;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class CatalogServiceImpl implements CatalogService {


    private final IMovieClient iMovieClient;

    private final ISerieClient iSerieClient;

    private final MovieRepository movieRepository;

    private final SerieRepository serieRepository;

    @Override
    @CircuitBreaker(name="catalog",fallbackMethod ="getCatalogFallbackValue")
    @Retry(name = "catalog")
    public Genre getAllByGenre(String genre) throws RuntimeException{
        log.info("Calling MovieService");
        return new Genre(iMovieClient.getMovieByGenre(genre, false), iSerieClient.getSeriesBygGenre(genre));
    }

    private void getCatalogFallbackValue(CallNotPermittedException ex)throws
            CircuitBreakerException {
        throw new CircuitBreakerException("Circuit breaker was activated");
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
