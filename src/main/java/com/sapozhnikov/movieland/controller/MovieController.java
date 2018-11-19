package com.sapozhnikov.movieland.controller;

import com.sapozhnikov.movieland.entity.Movie;
import com.sapozhnikov.movieland.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/v1")
public class MovieController {

    private MovieService movieService;

    @Autowired()
    public void setMovieService(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping(path="/movie", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Movie> getMovies(){
        return movieService.getAll();
    }
}
