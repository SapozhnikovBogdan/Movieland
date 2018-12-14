package com.sapozhnikov.movieland.dao;

import com.sapozhnikov.movieland.entity.Review;

import java.util.List;

public interface ReviewDao {
    List<Review> getByMovieId(int id);
}
