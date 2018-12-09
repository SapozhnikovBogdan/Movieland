package com.sapozhnikov.movielanddaojdbc.dao.jdbc;

import com.sapozhnikov.movielanddao.dao.GenreDao;
import com.sapozhnikov.movielandentity.entity.Genre;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/dao-jdbc-context.xml", "classpath:/spring/test-context.xml"})
@DirtiesContext
public class JdbcGenreDaoTest {
    @Autowired
    GenreDao genreDao;

    @Test
    public void testGetAll() throws Exception {
        List<Genre> expectedGenres = new ArrayList<>();
        Genre genre1 = new Genre(1, "драма");
        Genre genre2 = new Genre(2, "криминал");
        expectedGenres.add(genre1);
        expectedGenres.add(genre2);

        List<Genre> actualGenres = genreDao.getAll();
        assertEquals(expectedGenres.size(), actualGenres.size());
        for (Genre expectedGenre : expectedGenres) {
            assertTrue(actualGenres.contains(expectedGenre));
        }
    }
}
