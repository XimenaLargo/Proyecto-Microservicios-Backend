package com.dh.movieservice.service.impl;


import com.dh.movieservice.model.Movie;
import com.dh.movieservice.repository.MovieRepository;
import com.dh.movieservice.service.IMovieService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author vaninagodoy
 */

@Service
public class MovieService implements IMovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> findByGenre(String genre) {
        return movieRepository.findByGenre(genre);
    }

    @Override
    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }
    }