package com.dh.catalogservice.service;

import com.dh.catalogservice.model.Genre;
import com.dh.catalogservice.model.Movie;
import com.dh.catalogservice.model.Serie;

public interface CatalogService {


public Genre getAllByGenre (String genre);

public void saveMovie (Movie movie);

public void saveSerie(Serie serie);

}
