package com.movie.pers.jdbc.dao.impl;

import com.movie.pers.dao.BaseDao;
import com.movie.pers.dao.SingleReadDao;
import com.movie.pers.dao.UpdateDao;
import com.movie.pers.entities.Movie;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.*;
import java.util.List;

/**
 *
 * @author Aloren
 */
public class MovieDao extends JdbcDaoSupport implements BaseDao<Movie>,
        UpdateDao<Movie>, SingleReadDao<Movie> {

    private final MovieMapper movieMapper = new MovieMapper();

    @Override
    public Movie getById(int id) {
        String userFind = "SELECT * FROM MOVIES WHERE MOVIEID = " + id + " LIMIT 1";
        List<Movie> list = getJdbcTemplate().query(userFind, movieMapper);
        return getResultFromList(list);
    }

    @Override
    public List<Movie> getAll() {
        String sql = "SELECT * FROM MOVIES";
        return getJdbcTemplate().query(sql, movieMapper);
    }

    @Override
    public void update(Movie movie) {
        final String sql = "UPDATE MOVIES "
                + "SET TITLE=?, RATING=?, REL_YEAR=?, IMDBURL=?, PLOTSIMPLE=?, POSTERURL=?, IMDBID=?, DATE=? "
                + " WHERE MOVIEID = " + movie.getId();
        getJdbcTemplate().update(new MovieStatementCreator(sql, movie));
    }

    @Override
    public boolean save(final Movie movie) {
        try {
            final String sql = "INSERT INTO MOVIES "
                    + "(TITLE, RATING, REL_YEAR, IMDBURL, PLOTSIMPLE, POSTERURL, IMDBID, DATE) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            KeyHolder keyHolder = new GeneratedKeyHolder();
            getJdbcTemplate().update(new MovieStatementCreator(sql, movie), keyHolder);
            int id = keyHolder.getKey().intValue();
            movie.setId(id);
            return true;
        } catch (DuplicateKeyException e) {
            logger.warn("Tried to insert duplicate key. " + movie);
            return false;
        }
    }

    @Override
    public void delete(Movie movie) {
        String sql = "DELETE FROM MOVIES WHERE MOVIEID = " + movie.getId();
        getJdbcTemplate().update(sql);
    }

    public Movie findByImdbId(String imdbId) {
        String sql = "SELECT * FROM MOVIES WHERE IMDBID = " + imdbId + " LIMIT 1";
        List<Movie> list = getJdbcTemplate().query(sql, movieMapper);
        return getResultFromList(list);
    }

    private Movie getResultFromList(final List<Movie> list) {
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public int getNumberOfMovies() {
        String sql = "SELECT COUNT(*) FROM MOVIES";
        return getJdbcTemplate().queryForInt(sql);
    }

    public List<Movie> getAll(int offset, int limit) {
        if (offset < 0 || limit <= 0) {
            throw new IllegalArgumentException("Arguments limit<=0 or offset<0 not permitted: "
                    + "offset=" + offset + " limit=" + limit);
        }
        String sql = "SELECT * FROM MOVIES LIMIT " + limit + " OFFSET " + offset;
        return getJdbcTemplate().query(sql, movieMapper);
    }

    private class MovieStatementCreator implements PreparedStatementCreator {

        private final String query;
        private final Movie movie;

        public MovieStatementCreator(String sql, Movie movie) {
            this.query = sql;
            this.movie = movie;
        }

        @Override
        public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, movie.getTitle());
            ps.setFloat(2, movie.getRating());
            ps.setInt(3, movie.getYear());
            ps.setString(4, movie.getImdbUrl());
            ps.setString(5, movie.getPlotSimple());
            ps.setString(6, movie.getPosterUrl());
            ps.setString(7, movie.getImdbId());
            ps.setDate(8, new Date(movie.getReleaseDate().getTime()));
            return ps;
        }
    }

    public static class MovieMapper implements RowMapper<Movie> {

        @Override
        public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
            Movie movie = new Movie(
                    rs.getInt("MOVIEID"),
                    rs.getString("TITLE"),
                    rs.getFloat("RATING"),
                    rs.getInt("REL_YEAR"),
                    rs.getString("IMDBURL"),
                    rs.getString("PLOTSIMPLE"),
                    rs.getString("POSTERURL"),
                    rs.getString("IMDBID"),
                    rs.getDate("DATE"));
            return movie;
        }
    }
}
