package com.sapozhnikov.movieland.service;

import com.sapozhnikov.movieland.dao.GenreDao;
import com.sapozhnikov.movieland.entity.Genre;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultGenreService implements GenreService{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private GenreDao genreDao;

    @Override
    public List<Genre> getAll() {
        List<Genre> genres = genreDao.getAll();
        logger.debug("Service method getAll returned {} movies", genres.size());
        return genres;
    }

    @Autowired
    public void setGenreDao(GenreDao genreDao) {
        this.genreDao = genreDao;
    }
}
