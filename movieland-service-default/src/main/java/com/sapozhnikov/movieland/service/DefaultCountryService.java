package com.sapozhnikov.movieland.service;

import com.sapozhnikov.movieland.dao.CountryDao;
import com.sapozhnikov.movieland.entity.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultCountryService implements CountryService {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private CountryDao countryDao;

    @Autowired
    public DefaultCountryService(CountryDao countryDao) {
        this.countryDao = countryDao;
    }

    @Override
    public List<Country> getByMovieId(int id) {
        List<Country> countries = countryDao.getByMovieId(id);
        logger.debug("Service method getByMovieId returned {} countries", countries.size());
        return countries;
    }
}
