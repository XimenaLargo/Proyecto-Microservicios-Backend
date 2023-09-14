package com.dh.movieservice.service;

import com.dh.movieservice.model.Movie;

import java.util.List;

public interface IMovieService {

    public List<Movie> findByGenre(String genre);
    public Movie save(Movie movie);

}
