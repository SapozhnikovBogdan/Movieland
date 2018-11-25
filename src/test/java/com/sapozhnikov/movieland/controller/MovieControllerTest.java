package com.sapozhnikov.movieland.controller;

import com.sapozhnikov.movieland.dao.MovieDao;
import com.sapozhnikov.movieland.entity.Movie;
import com.sapozhnikov.movieland.service.MovieService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Collections;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/resources/spring/root-context.xml", "file:src/main/webapp/WEB-INF/dispatcherServlet-servlet.xml", "classpath:/spring/test-context.xml"})
@WebAppConfiguration
@DirtiesContext
public class MovieControllerTest {
    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    @InjectMocks
    MovieService movieService;

    @Mock
    MovieDao movieDao;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetMovies() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        Movie movie = new Movie();
        movie.setId(6);
        movie.setNameRussian("Начало");
        movie.setNameNative("Inception");
        movie.setYearOfRelease("2010");
        movie.setPrice(130.0);
        movie.setRating(8.6);
        movie.setPicturePath("https://images-na.ssl-images-amazon.com/images/M/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@._V1._SY209_CR0,0,140,209_.jpg");

        when(movieService.getAll()).thenReturn(Collections.singletonList(movie));

        mockMvc.perform(get("/movie"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", equalTo(6)))
                .andExpect(jsonPath("$[0].nameRussian", equalTo("Начало")))
                .andExpect(jsonPath("$[0].nameNative", equalTo("Inception")))
                .andExpect(jsonPath("$[0].yearOfRelease", equalTo("2010")))
                .andExpect(jsonPath("$[0].rating", equalTo(8.6)))
                .andExpect(jsonPath("$[0].price", equalTo(130.0)))
                .andExpect(jsonPath("$[0].picturePath", equalTo("https://images-na.ssl-images-amazon.com/images/M/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@._V1._SY209_CR0,0,140,209_.jpg")));
    }

    @Test
    public void testGetRandomMovies() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        Movie movie = new Movie();
        movie.setId(6);
        movie.setNameRussian("Начало");
        movie.setNameNative("Inception");
        movie.setYearOfRelease("2010");
        movie.setPrice(130.0);
        movie.setRating(8.6);
        movie.setPicturePath("https://images-na.ssl-images-amazon.com/images/M/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@._V1._SY209_CR0,0,140,209_.jpg");

        when(movieService.getRandom()).thenReturn(Collections.singletonList(movie));

        mockMvc.perform(get("/movie/random"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", equalTo(6)))
                .andExpect(jsonPath("$[0].nameRussian", equalTo("Начало")))
                .andExpect(jsonPath("$[0].nameNative", equalTo("Inception")))
                .andExpect(jsonPath("$[0].yearOfRelease", equalTo("2010")))
                .andExpect(jsonPath("$[0].rating", equalTo(8.6)))
                .andExpect(jsonPath("$[0].price", equalTo(130.0)))
                .andExpect(jsonPath("$[0].picturePath", equalTo("https://images-na.ssl-images-amazon.com/images/M/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@._V1._SY209_CR0,0,140,209_.jpg")));
    }

    @Test
    public void testGetMoviesByGenre() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        Movie movie = new Movie();
        movie.setId(11);
        movie.setNameRussian("Унесённые призраками");
        movie.setNameNative("Sen to Chihiro no kamikakushi");
        movie.setYearOfRelease("2001");
        movie.setRating(8.6);
        movie.setPrice(145.90);
        movie.setPicturePath("https://images-na.ssl-images-amazon.com/images/M/MV5BOGJjNzZmMmUtMjljNC00ZjU5LWJiODQtZmEzZTU0MjBlNzgxL2ltYWdlXkEyXkFqcGdeQXVyNTAyODkwOQ@@._V1._SY209_CR0,0,140,209_.jpg");

        when(movieService.getByGenre(anyInt())).thenReturn(Collections.singletonList(movie));

        int familyGenreId = 14;
        mockMvc.perform(get("/movie/genre/{genreId}", new Object[]{familyGenreId}))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", equalTo(11)))
                .andExpect(jsonPath("$[0].nameRussian", equalTo("Унесённые призраками")))
                .andExpect(jsonPath("$[0].nameNative", equalTo("Sen to Chihiro no kamikakushi")))
                .andExpect(jsonPath("$[0].yearOfRelease", equalTo("2001")))
                .andExpect(jsonPath("$[0].rating", equalTo(8.6)))
                .andExpect(jsonPath("$[0].price", equalTo(145.90)))
                .andExpect(jsonPath("$[0].picturePath", equalTo("https://images-na.ssl-images-amazon.com/images/M/MV5BOGJjNzZmMmUtMjljNC00ZjU5LWJiODQtZmEzZTU0MjBlNzgxL2ltYWdlXkEyXkFqcGdeQXVyNTAyODkwOQ@@._V1._SY209_CR0,0,140,209_.jpg")));
    }
}