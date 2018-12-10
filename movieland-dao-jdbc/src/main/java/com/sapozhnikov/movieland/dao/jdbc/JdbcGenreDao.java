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
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcGenreDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Genre> getAll() {
        return jdbcTemplate.query(getAllGenreSql, GENRE_ROW_MAPPER);
    }

    @Autowired
    public void setGetAllGenreSql(String getAllGenreSql) {
        this.getAllGenreSql = getAllGenreSql;
    }
}
