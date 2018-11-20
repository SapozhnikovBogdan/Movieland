package com.sapozhnikov.movieland.dao;

import com.sapozhnikov.movieland.entity.Movie;

import java.util.List;

public interface MovieDao {
    List<Movie> getAll();
}
