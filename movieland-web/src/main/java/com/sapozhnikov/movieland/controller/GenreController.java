package com.sapozhnikov.movieland.controller;

import com.sapozhnikov.movieland.entity.Genre;
import com.sapozhnikov.movieland.service.GenreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GenreController {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private GenreService defaultGenreService;

    @GetMapping(path = "/genre", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Genre> getAll(){
        logger.info("HTTP GET request came by path /genre" );
        return defaultGenreService.getAll();
    }

    @Autowired
    public void setDefaultGenreService(GenreService defaultGenreService) {
        this.defaultGenreService = defaultGenreService;
    }
}
