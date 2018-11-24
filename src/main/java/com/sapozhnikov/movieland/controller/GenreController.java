package com.sapozhnikov.movieland.controller;

import com.sapozhnikov.movieland.entity.Genre;
import com.sapozhnikov.movieland.service.DefaultGenreService;
import com.sapozhnikov.movieland.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GenreController {

    private GenreService defaultGenreService;

    @GetMapping(path = "/genre", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Genre> getAll(){
        return defaultGenreService.getAll();
    }

    @Autowired
    public void setDefaultGenreService(GenreService defaultGenreService) {
        this.defaultGenreService = defaultGenreService;
    }
}
