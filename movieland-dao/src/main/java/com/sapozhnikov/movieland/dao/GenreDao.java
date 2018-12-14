package com.sapozhnikov.movieland.dao;

import com.sapozhnikov.movieland.entity.Genre;

import java.util.List;

public interface GenreDao {
    List<Genre> getAll();
    List<Genre> getByMovieId(int id);
}
