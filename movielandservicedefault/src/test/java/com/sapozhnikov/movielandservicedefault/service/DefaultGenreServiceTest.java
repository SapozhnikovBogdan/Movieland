package com.sapozhnikov.movielandservicedefault.service;

import com.sapozhnikov.movielanddao.dao.GenreDao;
import com.sapozhnikov.movielandentity.entity.Genre;
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
public class DefaultGenreServiceTest {

    @Mock
    GenreDao genreDao;

    @InjectMocks
    DefaultGenreService defaultGenreService;

    @Test
    public void testGetAll(){
        List<Genre> expectedGenres = new ArrayList<>();
        Genre genre1 = new Genre(1, "драма");
        Genre genre2 = new Genre(2, "криминал");
        expectedGenres.add(genre1);
        expectedGenres.add(genre2);

        when(genreDao.getAll()).thenReturn(expectedGenres);
        List<Genre> actualGenres = defaultGenreService.getAll();
        assertEquals(expectedGenres.size(), actualGenres.size());
        for (Genre expectedGenre : expectedGenres) {
            assertTrue(actualGenres.contains(expectedGenre));
        }
    }
}
