package com.sapozhnikov.movieland.dao.jdbc;

import com.sapozhnikov.movieland.dao.GenreDao;
import com.sapozhnikov.movieland.dao.jdbc.mapper.GenreRowMapper;
import com.sapozhnikov.movieland.entity.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcGenreDao implements GenreDao {
    private static final GenreRowMapper GENRE_ROW_MAPPER = new GenreRowMapper();
    private String getAllGenreSql;
    private String getGenreByMovieIdSql;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcGenreDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Genre> getAll() {
        return jdbcTemplate.query(getAllGenreSql, GENRE_ROW_MAPPER);
    }

    @Override
    public List<Genre> getByMovieId(int id) {
        return jdbcTemplate.query(getGenreByMovieIdSql, GENRE_ROW_MAPPER, id);
    }

    @Autowired
    public void setGetAllGenreSql(String getAllGenreSql) {
        this.getAllGenreSql = getAllGenreSql;
    }

    @Autowired
    public void setGetGenreByMovieIdSql(String getGenreByMovieIdSql) {
        this.getGenreByMovieIdSql = getGenreByMovieIdSql;
    }
}
