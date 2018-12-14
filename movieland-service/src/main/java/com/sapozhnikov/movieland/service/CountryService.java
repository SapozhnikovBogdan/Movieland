package com.sapozhnikov.movieland.service;

import com.sapozhnikov.movieland.entity.Country;

import java.util.List;

public interface CountryService {
    List<Country> getByMovieId(int id);
}
