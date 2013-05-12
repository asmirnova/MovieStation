package com.movie.pers.jdbc.dao.impl;

import com.movie.pers.dao.BaseDao;
import com.movie.pers.entities.Favorite;
import com.movie.pers.entities.Movie;
import com.movie.pers.jdbc.dao.impl.MovieDao.MovieMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 *
 * @author Aloren
 */
public class FavoriteDao extends JdbcDaoSupport implements BaseDao<Favorite> {

    private final FavoriteMapper favoriteMapper = new FavoriteMapper();

    @Override
    public boolean save(final Favorite fav) {
        try {
            String sql = "INSERT INTO FAVORITES (USERID, MOVIEID) VALUES (?, ?)";
            getJdbcTemplate().update(sql, fav.getUserId(), fav.getMovie().getId());
            return true;
        } catch (DuplicateKeyException e) {
            logger.warn("Tried to insert duplicate key. " + fav);
            return false;
        }
    }

    @Override
    public void delete(Favorite fav) {
        String sql = "DELETE FROM FAVORITES WHERE USERID = ? AND MOVIEID = ?";
        getJdbcTemplate().update(sql, new Object[]{fav.getUserId(), fav.getMovie().getId()});
    }

    @Override
    public List<Favorite> getAll() {
        String userFind = "SELECT * FROM favorites "
                + "JOIN movies ON movies.movieid=favorites.movieid";
        return getJdbcTemplate().query(userFind, favoriteMapper);
    }

    public List<Favorite> getAll(int userId) {
        String userFind = "SELECT * FROM favorites "
                + "JOIN movies ON movies.movieid=favorites.movieid "
                + "WHERE favorites.userid = " + userId;
        return getJdbcTemplate().query(userFind, favoriteMapper);
    }

    public Favorite getById(int userId, int movieId) {
        String userFind = "SELECT * FROM favorites "
                + "JOIN movies ON movies.movieid=favorites.movieid "
                + "WHERE favorites.userid = " + userId
                + " AND favorites.movieid = " + movieId;
        List<Favorite> list = getJdbcTemplate().query(userFind, favoriteMapper);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    private static class FavoriteMapper implements RowMapper<Favorite> {

        @Override
        public Favorite mapRow(ResultSet rs, int rowNum) throws SQLException {
            MovieMapper mapper = new MovieMapper();
            Movie movie = mapper.mapRow(rs, rowNum);
            Favorite fav = new Favorite(rs.getInt("USERID"), movie);
            return fav;
        }
    }
}
