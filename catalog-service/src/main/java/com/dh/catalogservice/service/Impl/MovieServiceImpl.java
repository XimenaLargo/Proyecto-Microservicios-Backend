package com.dh.catalogservice.service.Impl;

import com.dh.catalogservice.model.Movie;
import com.dh.catalogservice.repository.MovieRepository;
import com.dh.catalogservice.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    @Override
    public List<Movie> getMoviesByGenre(String genre, Boolean throwError) throws RuntimeException {
        if (throwError) throw  new RuntimeException();
        return movieRepository.findAllMoviesByGenre(genre);
    }
}
