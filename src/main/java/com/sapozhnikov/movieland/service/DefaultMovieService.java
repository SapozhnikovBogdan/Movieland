package com.sapozhnikov.movieland.service;

import com.sapozhnikov.movieland.common.MovieRequestParam;
import com.sapozhnikov.movieland.common.SqlGenerator;
import com.sapozhnikov.movieland.dao.MovieDao;
import com.sapozhnikov.movieland.entity.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultMovieService implements MovieService {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private MovieDao movieDao;

    @Autowired
    public DefaultMovieService(MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    @Override
    public List<Movie> getAll() {
        List<Movie> movies = movieDao.getAll();
        logger.debug("Service method getAll returned {} movies", movies.size());
        return movies;
    }

    @Override
    public List<Movie> getAll(MovieRequestParam movieRequestParam) {
        List<Movie> movies = movieDao.getAll(movieRequestParam);
        logger.debug("Service method getAll with sorting returned {} movies", movies.size());
        return movies;
    }

    @Override
    public List<Movie> getRandom() {
        List<Movie> movies = movieDao.getRandom();
        logger.debug("Service method getRandom returned {} movies", movies.size());
        return movies;
    }

    @Override
    public List<Movie> getByGenre(int id) {
        List<Movie> movies = movieDao.getByGenre(id);
        logger.debug("Service method getByGenre returned {} movies", movies.size());
        return movies;
    }

    @Override
    public List<Movie> getByGenre(int id, MovieRequestParam movieRequestParam) {
        List<Movie> movies = movieDao.getByGenre(id, movieRequestParam);
        logger.debug("Service method getByGenre with sorting returned {} movies", movies.size());
        return movies;
    }
}
