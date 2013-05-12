package com.movie.web.service;

import com.movie.pers.entities.Movie;
import com.movie.pers.jdbc.dao.impl.MovieDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Aloren
 */
public class MovieService implements BaseService<Movie> {

    @Autowired
    private MovieDao movieDao;

    @Override
    public void add(Movie movie) {
        movieDao.save(movie);
    }

    @Override
    public Movie findById(int id) {
        return movieDao.getById(id);
    }

    @Override
    public void delete(Movie movie) {
        movieDao.delete(movie);
    }

    @Override
    public List<Movie> findAll() {
        return movieDao.getAll();
    }

    public int getNumberOfMoviePages(int maxPerPage) {
        int numberOfMovies = movieDao.getNumberOfMovies();
        return (int) Math.ceil(numberOfMovies * 1.0 / maxPerPage);
    }

    public List<Movie> findAll(int page, int maxPerPage) {
        int offset = (page - 1) * maxPerPage;
        return movieDao.getAll(offset, maxPerPage);
    }
}
