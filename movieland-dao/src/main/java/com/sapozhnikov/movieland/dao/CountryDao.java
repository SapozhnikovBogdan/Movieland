package com.sapozhnikov.movieland.dao;

import com.sapozhnikov.movieland.entity.Country;

import java.util.List;

public interface CountryDao {
    List<Country> getByMovieId(int id);
}
