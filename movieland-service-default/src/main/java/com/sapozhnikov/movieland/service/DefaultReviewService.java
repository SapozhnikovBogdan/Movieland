package com.sapozhnikov.movieland.service;

import com.sapozhnikov.movieland.dao.ReviewDao;
import com.sapozhnikov.movieland.entity.Review;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultReviewService implements ReviewService {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private ReviewDao reviewDao;

    @Autowired
    public DefaultReviewService(ReviewDao reviewDao) {
        this.reviewDao = reviewDao;
    }

    @Override
    public List<Review> getByMovieId(int id) {
        List<Review> reviews = reviewDao.getByMovieId(id);
        logger.debug("Service method getByMovieId returned {} reviews", reviews.size());
        return reviews;
    }
}
