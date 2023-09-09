package com.dh.catalogservice.service;

import com.dh.catalogservice.model.Genre;
import com.dh.catalogservice.model.Movie;
import com.dh.catalogservice.model.Serie;

import java.util.List;

public interface CatalogService {

   /* public List<Movie> getMoviesByGenre(String genre);

    public Movie saveMovie(Movie movie);
    public String create (Serie serie);

    public List<Serie> getSeriesBygGenre(String genre);*/

public Genre getAllByGenre (String genre);

}
