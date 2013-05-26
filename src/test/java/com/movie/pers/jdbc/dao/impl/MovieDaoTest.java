package com.movie.pers.jdbc.dao.impl;

import com.movie.pers.entities.Movie;
import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 *
 * @author Aloren
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/application-context.xml"})
@ActiveProfiles("test")
public class MovieDaoTest extends BaseDaoTest{
    
    private static final Movie testMovie1 = TestData.testMovie1;
    private static final Movie testMovie2 = TestData.testMovie2;

    private static final int NUM_TEST_ROWS = 2;
    @Autowired
    private MovieDao movieDao;

    @Test
    public void getAll() {
        List<Movie> movies = movieDao.getAll();
        assertTrue("There must be " + NUM_TEST_ROWS
                + " test rows in db, but was " + movies.size(), movies.size() == NUM_TEST_ROWS);
        assertEquals("First movie was not read correctly.", testMovie1, movies.get(0));
        assertEquals("Second movie was not read correctly.", testMovie2, movies.get(1));
    }

    @Test
    public void getMovieById() {
        Movie movie = movieDao.getById(testMovie1.getId());
        assertNotNull(movie);
        assertEquals(testMovie1, movie);
    }

    @Test
    public void save() {
        Movie savedMovie = saveUniqueMovie("tt00");
        Movie foundMovie = movieDao.getById(savedMovie.getId());
        assertEquals("Movie in DB was not saved correctly.", savedMovie, foundMovie);
    }

    @Test
    public void saveWithDuplicateLogin() {
        boolean saved = saveNotUniqueMovie(testMovie1.getImdbId());
        assertFalse("Not unique movie must not be saved to DB.", saved);
    }

    @Test
    public void delete() {
        Movie savedMovie = saveUniqueMovie("tt01");
        movieDao.delete(savedMovie);
        Movie deletedMovie = movieDao.getById(savedMovie.getId());
        assertNull("Deleted movie must not reside in DB anymore.", deletedMovie);
    }

    @Test
    public void update() {
        Movie movie = saveUniqueMovie("tt02");
        final String updatedImdbId = "tt95";
        movie.setImdbId(updatedImdbId);
        movieDao.update(movie);

        Movie found = movieDao.getById(movie.getId());
        assertEquals(updatedImdbId, found.getImdbId());
    }

    private Movie saveUniqueMovie(String imdbId) {
        Movie movie = new Movie("TestTitle", 5.6f, 1987, "imdbIrl", "PlotSimple",
                "poster.url", imdbId, new DateTime(2000, 4, 5, 0, 0).toDate());
        movieDao.save(movie);
        final Integer id = movie.getId();
        assertNotNull("Id for saved movie must be set.", id);
        return movie;
    }

    private boolean saveNotUniqueMovie(String imdbId) {
        Movie movie = new Movie("TestTitle", 5.6f, 1987, "imdbIrl", "PlotSimple",
                "poster.url", imdbId, new DateTime(2000, 4, 5, 0, 0).toDate());
        boolean saved = movieDao.save(movie);
        assertNull("Id for not saved, not unique movie must be NOT set.", movie.getId());
        return saved;
    }
}
