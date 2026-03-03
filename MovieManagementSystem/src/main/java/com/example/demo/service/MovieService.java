package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.Movie;

public interface MovieService {

    void saveMovie(Movie movie);
    List<Movie> getAllMovies();
    Movie getMovieById(Long id);
    void updateMovie(Movie movie);
    void deleteMovie(Long id);
}
