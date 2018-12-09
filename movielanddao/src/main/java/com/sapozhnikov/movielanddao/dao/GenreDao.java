package com.sapozhnikov.movielanddao.dao;

import com.sapozhnikov.movielandentity.entity.Genre;

import java.util.List;

public interface GenreDao {
    List<Genre> getAll();
}
