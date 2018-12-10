package com.sapozhnikov.movieland.dao.jdbc.mapper;

import com.sapozhnikov.movieland.entity.Genre;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GenreRowMapperTest {

    @Test
    public void testMapRow() throws SQLException {
        ResultSet resultSet = mock(ResultSet.class);
        when(resultSet.getInt("id")).thenReturn(1);
        when(resultSet.getString("name")).thenReturn("драма");

        GenreRowMapper genreRowMapper = new GenreRowMapper();
        Genre actualGenre = genreRowMapper.mapRow(resultSet, 1);

        assertEquals(1, actualGenre.getId());
        assertEquals("драма", actualGenre.getName());
    }
}
