package com.sapozhnikov.movieland.dao.cache;

import com.sapozhnikov.movieland.dao.GenreDao;
import com.sapozhnikov.movieland.entity.Genre;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Primary
@Repository
public class CachedGenreDao implements GenreDao {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private volatile List<Genre> cachedGenres;
    private GenreDao jdbcGenreDao;

    @Override
    public List<Genre> getAll() {
        return new ArrayList<>(cachedGenres);
    }

    @PostConstruct
    @Scheduled(fixedDelayString = "${schedule.cache.genre.fixed_delay}",
               initialDelayString = "${schedule.cache.genre.initial_delay}")
    private void invalidateCache(){
        long startTime = System.currentTimeMillis();
        logger.info("CashedGenre was invalidated");
        cachedGenres = jdbcGenreDao.getAll();
        long endTime = System.currentTimeMillis();
        logger.info("CashedGenre was refreshed for {} ms ", endTime - startTime);
    }

    @Autowired
    public void setJdbcGenreDao(GenreDao jdbcGenreDao) {
        this.jdbcGenreDao = jdbcGenreDao;
    }

}
