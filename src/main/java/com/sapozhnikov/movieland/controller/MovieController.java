package com.sapozhnikov.movieland.controller;

import com.sapozhnikov.movieland.entity.Movie;
import com.sapozhnikov.movieland.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private MovieService movieService;

    @GetMapping(path="/movie", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Movie> getMovies(){
        logger.info("HTTP GET request came by path /movie");
        return movieService.getAll();
    }

    @GetMapping(path="/movie/random", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Movie> getRandomMovies(){
        logger.info("Get request came by path /movie/random");
        return movieService.getRandom();
    }

    @Autowired()
    public void setMovieService(MovieService movieService) {
        this.movieService = movieService;
    }
}
