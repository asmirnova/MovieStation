package com.movie.pers.jdbc.dao.impl;

import com.movie.pers.dao.BaseDao;
import com.movie.pers.dao.SingleReadDao;
import com.movie.pers.entities.Comment;
import com.movie.pers.entities.Favorite;
import com.movie.pers.entities.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 *
 * @author Aloren
 */
public class CommentDao extends JdbcDaoSupport implements BaseDao<Comment>, SingleReadDao<Comment> {

    private final static CommentMapper commentMapper = new CommentMapper();

    @Override
    public boolean save(Comment t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Comment t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void delete(int commentId) {
        String sql = "DELETE FROM comments WHERE id = " + commentId;
        getJdbcTemplate().update(sql);
    }

    @Override
    public List<Comment> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Comment> getAllForUser(int userId) {
        String sql = "SELECT * FROM COMMENTS "
                + "WHERE USERID = " + userId;
        return getJdbcTemplate().query(sql, commentMapper);
    }

    public List<Comment> getAllForMovie(int movieId) {
        String sql = "SELECT * FROM COMMENTS "
                + "WHERE MOVIEID = " + movieId;
        return getJdbcTemplate().query(sql, commentMapper);
    }

    @Override
    public Comment getById(int id) {
        String sql = "SELECT * FROM COMMENTS WHERE ID = " + id + " LIMIT 1";
        final List<Comment> list = getJdbcTemplate().query(sql, commentMapper);
        return getResultFromList(list);
    }

    private Comment getResultFromList(final List<Comment> list) {
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public int getNumberOfCommentsForMovie(int movieId) {
        String sql = "SELECT COUNT(*) FROM COMMENTS WHERE MOVIEID = " + movieId;
        return getJdbcTemplate().queryForInt(sql);
    }

    public List<Comment> getAllForMovie(int movieId, int offset, int limit) {
        if (offset < 0 || limit <= 0) {
            throw new IllegalArgumentException("Arguments limit<=0 or offset<0 not permitted: "
                    + "offset=" + offset + " limit=" + limit);
        }
        String sql = "SELECT * FROM COMMENTS WHERE MOVIEID = " + movieId + " LIMIT " + limit + " OFFSET " + offset;
        return getJdbcTemplate().query(sql, commentMapper);
    }

    static class CommentMapper implements RowMapper<Comment> {

        @Override
        public Comment mapRow(ResultSet rs, int row) throws SQLException {
            Comment comment = new Comment(rs.getInt("id"),
                    rs.getString("title"),
                    rs.getString("text"),
                    rs.getInt("userid"),
                    rs.getInt("movieid"),
                    rs.getFloat("rating"));
            return comment;
        }
    }
}
