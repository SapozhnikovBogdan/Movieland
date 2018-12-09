package com.sapozhnikov.movielandservicedefault.service;

import com.sapozhnikov.movielanddao.dao.GenreDao;
import com.sapozhnikov.movielandentity.entity.Genre;
import com.sapozhnikov.movielandservice.service.GenreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultGenreService implements GenreService {
    private final Logger logger = LoggerFactory.getLogger(getClass());
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
