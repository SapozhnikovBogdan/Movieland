package com.sapozhnikov.movieland.service;

import com.sapozhnikov.movieland.common.MovieRequestParam;
import com.sapozhnikov.movieland.entity.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> getAll();
    List<Movie> getAll(MovieRequestParam movieRequestParam);
    List<Movie> getRandom();
    List<Movie> getByGenre(int id);
    List<Movie> getByGenre(int id, MovieRequestParam movieRequestParam);
}
