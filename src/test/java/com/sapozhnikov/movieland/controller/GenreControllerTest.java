package com.sapozhnikov.movieland.controller;

import com.sapozhnikov.movieland.dao.GenreDao;
import com.sapozhnikov.movieland.dao.MovieDao;
import com.sapozhnikov.movieland.entity.Genre;
import com.sapozhnikov.movieland.service.GenreService;
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
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/resources/spring/root-context.xml", "file:src/main/webapp/WEB-INF/dispatcherServlet-servlet.xml", "classpath:/spring/test-context.xml"})
@WebAppConfiguration
@DirtiesContext
public class GenreControllerTest {
    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    @InjectMocks
    GenreService genreService;

    @Mock
    GenreDao genreDao;

    @Before
    public void setUp() throws Exception {
        //
    }

    @Test
    public void testGetMovies() throws Exception {
        MockitoAnnotations.initMocks(this);
        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        Genre genre = new Genre(1, "драма");

        when(genreService.getAll()).thenReturn(Collections.singletonList(genre));

        mockMvc.perform(get("/genre"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", equalTo(1)))
                .andExpect(jsonPath("$[0].name", equalTo("драма")));
    }

}
