package com.dh.movieservice.service;

import com.dh.movieservice.model.Movie;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface IMovieService {

    public List<Movie> findByGenre(String genre, Boolean throwError);
    public Movie save(Movie movie);

}
