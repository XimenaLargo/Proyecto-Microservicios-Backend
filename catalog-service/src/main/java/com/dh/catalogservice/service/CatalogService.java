package com.dh.catalogservice.service;

import com.dh.catalogservice.model.Genre;
import com.dh.catalogservice.model.Movie;

import java.util.List;

public interface CatalogService {

    public List<Movie> getMoviesByGenre(String genre);

    public Movie saveMovie(Movie movie);

    public Genre findByGenre (String genre);

}
