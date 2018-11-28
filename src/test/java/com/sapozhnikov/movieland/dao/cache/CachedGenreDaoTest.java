package com.sapozhnikov.movieland.dao.cache;

import com.sapozhnikov.movieland.dao.GenreDao;
import com.sapozhnikov.movieland.entity.Genre;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/resources/spring/root-context.xml", "file:src/main/webapp/WEB-INF/dispatcherServlet-servlet.xml", "classpath:/spring/test-context.xml"})
@DirtiesContext
public class CachedGenreDaoTest {
    @Autowired
    private GenreDao cachedGenreDao;

    @Autowired
    @Qualifier("jdbcGenreDao")
    private GenreDao jdbcGenreDao;

    @Test
    public void testGetAll() throws Exception {
        List<Genre> expectedGenres = jdbcGenreDao.getAll();
        List<Genre> actualGenres = cachedGenreDao.getAll();

        assertEquals(expectedGenres.size(), actualGenres.size());

        for (Genre expectedGenre : expectedGenres) {
            assertTrue(actualGenres.contains(expectedGenre));
        }
    }

}