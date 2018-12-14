package com.sapozhnikov.movieland.dao.jdbc;

import com.sapozhnikov.movieland.dao.CountryDao;
import com.sapozhnikov.movieland.dao.jdbc.mapper.CountryRowMapper;
import com.sapozhnikov.movieland.entity.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcCountryDao implements CountryDao {
    private static final CountryRowMapper COUNTRY_ROW_MAPPER = new CountryRowMapper();
    private JdbcTemplate jdbcTemplate;
    private String getCountryByMovieIdSql;

    @Autowired
    public JdbcCountryDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Country> getByMovieId(int id) {
        return  jdbcTemplate.query(getCountryByMovieIdSql, COUNTRY_ROW_MAPPER, id);
    }

    @Autowired
    public void setGetCountryByMovieIdSql(String getCountryByMovieIdSql) {
        this.getCountryByMovieIdSql = getCountryByMovieIdSql;
    }
}
