package com.dh.movieservice.service.impl;


import com.dh.movieservice.model.Movie;
import com.dh.movieservice.queue.MovieSender;
import com.dh.movieservice.repository.MovieRepository;
import com.dh.movieservice.service.IMovieService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author vaninagodoy
 */

@Service
@AllArgsConstructor
public class MovieService implements IMovieService {

    private final MovieRepository movieRepository;

    private final MovieSender movieSender;


    @Override
    public List<Movie> findByGenre(String genre, Boolean throwError) throws RuntimeException{
        if(throwError) throw new RuntimeException();
        return movieRepository.findByGenre(genre);
    }


    @Override
    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }
    }
