package com.sapozhnikov.movielandweb.controller;

import com.sapozhnikov.movielandentity.common.MovieRequestParam;
import com.sapozhnikov.movielandentity.common.SortDirection;
import com.sapozhnikov.movielandentity.common.SortDirectionConverter;
import com.sapozhnikov.movielandentity.entity.Movie;
import com.sapozhnikov.movielandservice.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private MovieService movieService;

    @GetMapping(path="/movie", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> getMovies(@RequestParam(name = "rating", required = false) SortDirection ratingSortDirection,
                                       @RequestParam(name = "price", required = false) SortDirection priceSortDirection){
        logger.info("HTTP GET request came by path /movie");
        if (ratingSortDirection == SortDirection.ASC || ratingSortDirection != null && priceSortDirection != null) {
            logger.error("Request params {} is not allowed here", ratingSortDirection == SortDirection.ASC ? "rating=ASC" : "rating=" + (ratingSortDirection.name()) + "; price=" + priceSortDirection.name());
            return ResponseEntity.badRequest().build();
        }

        if (ratingSortDirection == null && priceSortDirection == null){
            return ResponseEntity.ok(movieService.getAll());
        }

        return ResponseEntity.ok(movieService.getAll(getMovieRequestParam(ratingSortDirection, priceSortDirection)));
    }

    @GetMapping(path="/movie/random", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Movie> getRandomMovies(){
        logger.info("HTTP GET request came by path /movie/random");
        return movieService.getRandom();
    }

    @GetMapping(path="/movie/genre/{genreId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> getMoviesByGenre(@PathVariable int genreId,
                                              @RequestParam(name = "rating", required = false) SortDirection ratingSortDirection,
                                              @RequestParam(name = "price", required = false) SortDirection priceSortDirection){
        logger.info("HTTP GET request came by path /movie/genre/{}", genreId);

        if (!isValidParams(ratingSortDirection, priceSortDirection)){
            return ResponseEntity.badRequest().build();
        }

        if (ratingSortDirection == null && priceSortDirection == null){
            return ResponseEntity.ok(movieService.getByGenre(genreId));
        }

        return ResponseEntity.ok(movieService.getByGenre(genreId, getMovieRequestParam(ratingSortDirection, priceSortDirection)));
    }

    @Autowired()
    public void setMovieService(MovieService movieService) {
        this.movieService = movieService;
    }

    @InitBinder
    public void initBinder(final WebDataBinder webdataBinder) {
        webdataBinder.registerCustomEditor(SortDirection.class, new SortDirectionConverter());
    }

    private boolean isValidParams(SortDirection ratingSortDirection, SortDirection priceSortDirection){
        if (ratingSortDirection == SortDirection.ASC || (ratingSortDirection != null && priceSortDirection != null)) {
            logger.error("Request params {} is not allowed here", ratingSortDirection == SortDirection.ASC ? "rating=ASC" : "rating=" + (ratingSortDirection.name()) + "; price=" + priceSortDirection.name());
            return false;
        }
        return true;
    }

    private MovieRequestParam getMovieRequestParam(@RequestParam(name = "rating", required = false) SortDirection ratingSortDirection, @RequestParam(name = "price", required = false) SortDirection priceSortDirection) {
        MovieRequestParam movieRequestParam = new MovieRequestParam();

        if (ratingSortDirection != null) {
            movieRequestParam.setSortDirection(ratingSortDirection);
            movieRequestParam.setSortField("rating");
        }

        if (priceSortDirection != null) {
            movieRequestParam.setSortDirection(priceSortDirection);
            movieRequestParam.setSortField("price");
        }
        return movieRequestParam;
    }

}
