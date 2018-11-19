package com.sapozhnikov.movieland.dao.jdbc.mapper;

import com.sapozhnikov.movieland.entity.Movie;
import org.junit.Test;
import org.springframework.test.annotation.DirtiesContext;

import java.sql.ResultSet;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
public class MovieRowMapperTest {
    @Test
    public void testMapRow() throws Exception {
        ResultSet resultSet = mock(ResultSet.class);
        when(resultSet.getInt("id")).thenReturn(6);
        when(resultSet.getString("name_russian")).thenReturn("Начало");
        when(resultSet.getString("name_native")).thenReturn("Inception");
        when(resultSet.getString("year_of_release")).thenReturn("2010");
        when(resultSet.getDouble("rating")).thenReturn(8.6);
        when(resultSet.getDouble("price")).thenReturn(130.0);
        when(resultSet.getString("picture_path")).thenReturn("https://images-na.ssl-images-amazon.com/images/M/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@._V1._SY209_CR0,0,140,209_.jpg");

        MovieRowMapper movieRowMapper = new MovieRowMapper();
        Movie actualMovie = movieRowMapper.mapRow(resultSet, 1);

        assertEquals(6, actualMovie.getId());
        assertEquals("Начало", actualMovie.getNameRussian());
        assertEquals("Inception", actualMovie.getNameNative());
        assertEquals("2010", actualMovie.getYearOfRelease());
        assertEquals(8.6, actualMovie.getRating(), 0.1);
        assertEquals(130.0, actualMovie.getPrice(), 0.1);
        assertEquals("https://images-na.ssl-images-amazon.com/images/M/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@._V1._SY209_CR0,0,140,209_.jpg", actualMovie.getPicturePath());
    }


}