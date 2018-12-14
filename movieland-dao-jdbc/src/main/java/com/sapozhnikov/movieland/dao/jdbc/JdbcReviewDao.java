package com.sapozhnikov.movieland.dao.jdbc;

import com.sapozhnikov.movieland.dao.ReviewDao;
import com.sapozhnikov.movieland.dao.jdbc.mapper.ReviewRowMapper;
import com.sapozhnikov.movieland.entity.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcReviewDao implements ReviewDao{
    private static final ReviewRowMapper REVIEW_ROW_MAPPER = new ReviewRowMapper();
    private JdbcTemplate jdbcTemplate;
    private String getReviewByMovieIdSql;

    @Autowired
    public JdbcReviewDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Review> getByMovieId(int id) {
        return jdbcTemplate.query(getReviewByMovieIdSql, REVIEW_ROW_MAPPER, id);
    }

    @Autowired
    public void setGetReviewByMovieIdSql(String getReviewByMovieIdSql) {
        this.getReviewByMovieIdSql = getReviewByMovieIdSql;
    }

}
