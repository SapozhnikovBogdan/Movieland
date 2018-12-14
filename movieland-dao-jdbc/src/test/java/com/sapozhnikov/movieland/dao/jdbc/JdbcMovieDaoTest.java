package com.sapozhnikov.movieland.dao.jdbc;

import com.sapozhnikov.movieland.dao.MovieDao;
import com.sapozhnikov.movieland.entity.Movie;
import org.junit.Before;
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
public class JdbcMovieDaoTest {

    private List<Movie> expectedMovies;
    @Autowired
    private MovieDao movieDao;

    @Before
    public void setUp() throws Exception {
        expectedMovies = new ArrayList<>();
    }

    @Test
    public void testGetAll() throws Exception {
        Movie movie1 = new Movie();
        movie1.setId(6);
        movie1.setNameRussian("Начало");
        movie1.setNameNative("Inception");
        movie1.setYearOfRelease("2010");
        movie1.setDescription("Кобб — талантливый вор, лучший из лучших в опасном искусстве извлечения: он крадет ценные секреты из глубин подсознания во время сна, когда человеческий разум наиболее уязвим. Редкие способности Кобба сделали его ценным игроком в привычном к предательству мире промышленного шпионажа, но они же превратили его в извечного беглеца и лишили всего, что он когда-либо любил.");
        movie1.setPrice(130.0);
        movie1.setRating(8.6);
        movie1.setPicturePath("https://images-na.ssl-images-amazon.com/images/M/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@._V1._SY209_CR0,0,140,209_.jpg");

        Movie movie2 = new Movie();
        movie2.setId(7);
        movie2.setNameRussian("Жизнь прекрасна");
        movie2.setNameNative("La vita è bella");
        movie2.setYearOfRelease("1997");
        movie2.setDescription("Во время II Мировой войны в Италии в концлагерь были отправлены евреи, отец и его маленький сын. Жена, итальянка, добровольно последовала вслед за ними. В лагере отец сказал сыну, что все происходящее вокруг является очень большой игрой за приз в настоящий танк, который достанется тому мальчику, который сможет не попасться на глаза надзирателям. Он сделал все, чтобы сын поверил в игру и остался жив, прячась в бараке.");
        movie2.setPrice(145.99);
        movie2.setRating(8.2);
        movie2.setPicturePath("https://images-na.ssl-images-amazon.com/images/M/MV5BYmJmM2Q4NmMtYThmNC00ZjRlLWEyZmItZTIwOTBlZDQ3NTQ1XkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1._SY209_CR0,0,140,209_.jpg");

        expectedMovies.add(movie1);
        expectedMovies.add(movie2);

        List<Movie> actualMovies = movieDao.getAll();

        assertEquals(expectedMovies.size(), actualMovies.size());
        for (Movie expectedMovie : expectedMovies) {
            assertTrue(actualMovies.contains(expectedMovie));
        }
    }

    @Test
    public void testGetRandom(){
        List<Movie> actualMovies = movieDao.getRandom();
        int expectedRandomMovieCount = 3;
        assertEquals(expectedRandomMovieCount, actualMovies.size());
    }

    @Test
    public void testGetByGenre(){
        Movie movie1 = new Movie();
        movie1.setId(11);
        movie1.setNameRussian("Унесённые призраками");
        movie1.setNameNative("Sen to Chihiro no kamikakushi");
        movie1.setYearOfRelease("2001");
        movie1.setDescription("Маленькая Тихиро вместе с мамой и папой переезжают в новый дом. Заблудившись по дороге, они оказываются в странном пустынном городе, где их ждет великолепный пир. Родители с жадностью набрасываются на еду и к ужасу девочки превращаются в свиней, став пленниками злой колдуньи Юбабы, властительницы таинственного мира древних богов и могущественных духов.");
        movie1.setPrice(145.90);
        movie1.setRating(8.6);
        movie1.setPicturePath("https://images-na.ssl-images-amazon.com/images/M/MV5BOGJjNzZmMmUtMjljNC00ZjU5LWJiODQtZmEzZTU0MjBlNzgxL2ltYWdlXkEyXkFqcGdeQXVyNTAyODkwOQ@@._V1._SY209_CR0,0,140,209_.jpg");

        Movie movie2 = new Movie();
        movie2.setId(18);
        movie2.setNameRussian("Как приручить дракона");
        movie2.setNameNative("How to Train Your Dragon");
        movie2.setYearOfRelease("2010");
        movie2.setDescription("Вы узнаете историю подростка Иккинга, которому не слишком близки традиции его героического племени, много лет ведущего войну с драконами. Мир Иккинга переворачивается с ног на голову, когда он неожиданно встречает дракона Беззубика, который поможет ему и другим викингам увидеть привычный мир с совершенно другой стороны…");
        movie2.setPrice(182.00);
        movie2.setRating(8.2);
        movie2.setPicturePath("https://images-na.ssl-images-amazon.com/images/M/MV5BMjA5NDQyMjc2NF5BMl5BanBnXkFtZTcwMjg5ODcyMw@@._V1._SY209_CR0,0,140,209_.jpg");

        expectedMovies.add(movie1);
        expectedMovies.add(movie2);

        int familyGenreId = 14;
        List<Movie> actualMovies = movieDao.getByGenre(familyGenreId);

        assertEquals(expectedMovies.size(), actualMovies.size());
        for (Movie expectedMovie : expectedMovies) {
            assertTrue(actualMovies.contains(expectedMovie));
        }
    }

    @Test
    public void getById() throws Exception {
        Movie expectedMovie = new Movie();
        expectedMovie.setId(6);
        expectedMovie.setNameRussian("Начало");
        expectedMovie.setNameNative("Inception");
        expectedMovie.setYearOfRelease("2010");
        expectedMovie.setDescription("Кобб — талантливый вор, лучший из лучших в опасном искусстве извлечения: он крадет ценные секреты из глубин подсознания во время сна, когда человеческий разум наиболее уязвим. Редкие способности Кобба сделали его ценным игроком в привычном к предательству мире промышленного шпионажа, но они же превратили его в извечного беглеца и лишили всего, что он когда-либо любил.");
        expectedMovie.setPrice(130.0);
        expectedMovie.setRating(8.6);
        expectedMovie.setPicturePath("https://images-na.ssl-images-amazon.com/images/M/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@._V1._SY209_CR0,0,140,209_.jpg");

        Movie actualMovie = movieDao.getById(expectedMovie.getId());

        assertEquals(actualMovie, expectedMovie);

    }

}