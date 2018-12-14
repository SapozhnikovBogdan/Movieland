package com.sapozhnikov.movieland.dao.jdbc.mapper;

import com.sapozhnikov.movieland.entity.Review;
import com.sapozhnikov.movieland.entity.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReviewRowMapper implements RowMapper<Review> {
    @Nullable
    @Override
    public Review mapRow(ResultSet resultSet, int i) throws SQLException {
        Review review = new Review();
        review.setId(resultSet.getInt("id"));
        review.setText(resultSet.getString("comment"));
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setNickname(resultSet.getString("nick_name"));
        review.setUser(user);
        return review;
    }
}
