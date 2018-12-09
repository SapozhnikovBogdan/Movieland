package com.sapozhnikov.movielanddao.dao;

import com.sapozhnikov.movielandentity.common.MovieRequestParam;
import com.sapozhnikov.movielandentity.entity.Movie;

import java.util.List;

public interface MovieDao {
    List<Movie> getAll();
    List<Movie> getAll(MovieRequestParam movieRequestParam);
    List<Movie> getRandom();
    List<Movie> getByGenre(int id);
    List<Movie> getByGenre(int id, MovieRequestParam movieRequestParam);
}
