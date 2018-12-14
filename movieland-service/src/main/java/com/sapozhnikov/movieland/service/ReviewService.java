package com.sapozhnikov.movieland.service;

import com.sapozhnikov.movieland.entity.Review;

import java.util.List;

public interface ReviewService {
    List<Review> getByMovieId(int id);
}
