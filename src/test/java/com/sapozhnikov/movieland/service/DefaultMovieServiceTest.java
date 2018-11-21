package com.sapozhnikov.movieland.service;

import com.sapozhnikov.movieland.dao.MovieDao;
import com.sapozhnikov.movieland.entity.Movie;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DefaultMovieServiceTest {

    @Mock
    MovieDao movieDao;

    @InjectMocks
    DefaultMovieService movieService;

    @Test
    public void testGetAll() throws Exception {
        List<Movie> expectedMovies = new ArrayList<>();

        Movie movie1 = new Movie();
        movie1.setId(6);
        movie1.setNameRussian("Начало");
        movie1.setNameNative("Inception");
        movie1.setYearOfRelease("2010");
        movie1.setPrice(130.0);
        movie1.setRating(8.6);
        movie1.setPicturePath("https://images-na.ssl-images-amazon.com/images/M/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@._V1._SY209_CR0,0,140,209_.jpg");

        Movie movie2 = new Movie();
        movie2.setId(7);
        movie2.setNameRussian("Жизнь прекрасна");
        movie2.setNameNative("La vita è bella");
        movie2.setYearOfRelease("1997");
        movie2.setPrice(145.99);
        movie2.setRating(8.2);
        movie2.setPicturePath("https://images-na.ssl-images-amazon.com/images/M/MV5BYmJmM2Q4NmMtYThmNC00ZjRlLWEyZmItZTIwOTBlZDQ3NTQ1XkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1._SY209_CR0,0,140,209_.jpg");

        expectedMovies.add(movie1);
        expectedMovies.add(movie2);

        when(movieDao.getAll()).thenReturn(expectedMovies);

        List<Movie> actualMovies = movieService.getAll();

        assertEquals(expectedMovies.size(), actualMovies.size());
        for (Movie expectedMovie : expectedMovies) {
            assertTrue(actualMovies.contains(expectedMovie));
        }
    }

    @Test
    public void testGetRandom() throws Exception {
        List<Movie> expectedMovies = new ArrayList<>();

        Movie movie1 = new Movie();
        movie1.setId(6);
        movie1.setNameRussian("Начало");
        movie1.setNameNative("Inception");
        movie1.setYearOfRelease("2010");
        movie1.setPrice(130.0);
        movie1.setRating(8.6);
        movie1.setPicturePath("https://images-na.ssl-images-amazon.com/images/M/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@._V1._SY209_CR0,0,140,209_.jpg");

        Movie movie2 = new Movie();
        movie2.setId(7);
        movie2.setNameRussian("Жизнь прекрасна");
        movie2.setNameNative("La vita è bella");
        movie2.setYearOfRelease("1997");
        movie2.setPrice(145.99);
        movie2.setRating(8.2);
        movie2.setPicturePath("https://images-na.ssl-images-amazon.com/images/M/MV5BYmJmM2Q4NmMtYThmNC00ZjRlLWEyZmItZTIwOTBlZDQ3NTQ1XkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1._SY209_CR0,0,140,209_.jpg");

        expectedMovies.add(movie1);
        expectedMovies.add(movie2);

        when(movieDao.getRandom()).thenReturn(expectedMovies);

        List<Movie> actualMovies = movieService.getRandom();

        assertEquals(expectedMovies.size(), actualMovies.size());
        for (Movie expectedMovie : expectedMovies) {
            assertTrue(actualMovies.contains(expectedMovie));
        }
    }

}