package com.sapozhnikov.movieland.dao.jdbc;

import com.sapozhnikov.movieland.dao.MovieDao;
import com.sapozhnikov.movieland.dao.jdbc.mapper.MovieRowMapper;
import com.sapozhnikov.movieland.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcMovieDao implements MovieDao {
    private static final MovieRowMapper MOVIE_ROW_MAPPER = new MovieRowMapper();
    private JdbcTemplate jdbcTemplate;
    private String getAllMovieSql;
    private String getRandomMovieSql;
    private String getMovieByGenreSql;

    @Autowired
    public JdbcMovieDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Movie> getAll() {
        return jdbcTemplate.query(getAllMovieSql, MOVIE_ROW_MAPPER);
    }

    @Override
    public List<Movie> getRandom() {
        return jdbcTemplate.query(getRandomMovieSql, MOVIE_ROW_MAPPER);
    }

    @Override
    public List<Movie> getByGenre(int id) {
        return jdbcTemplate.query(getMovieByGenreSql, new Object[]{id}, MOVIE_ROW_MAPPER);
    }

    @Autowired
    public void setGetAllMovieSql(String getAllMovieSql) {
        this.getAllMovieSql = getAllMovieSql;
    }

    @Autowired
    public void setGetRandomMovieSql(String getRandomMovieSql) {
        this.getRandomMovieSql = getRandomMovieSql;
    }

    @Autowired
    public void setGetMovieByGenreSql(String getMovieByGenreSql) {
        this.getMovieByGenreSql = getMovieByGenreSql;
    }
}

