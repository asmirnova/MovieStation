package com.movie.pers.jdbc.dao.impl;

import com.movie.pers.dao.BaseDao;
import com.movie.pers.dao.SingleReadDao;
import com.movie.pers.dao.UpdateDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.movie.pers.entities.User;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

/**
 *
 * @author Aloren
 */
public class UserDao extends JdbcDaoSupport implements BaseDao<User>,
        UpdateDao<User>, SingleReadDao<User> {

    private final RowMapper<User> userMapper;

    public UserDao() {
        this.userMapper = new UserMapper();
    }

    @Override
    public User getById(int userId) {
        String userFind = "SELECT * FROM USERS WHERE USERID = " + userId + " LIMIT 1";
        final List<User> list = getJdbcTemplate().query(userFind, userMapper);
        return getResultFromList(list);
    }

    public boolean isAdmin(String userName) {
        String sql = "SELECT is_admin FROM admins JOIN users ON users.userid=admins.userid WHERE users.login='" + userName + "'";
        final List<Boolean> list = getJdbcTemplate().queryForList(sql, Boolean.class);
        if (list.isEmpty()) {
            return false;
        }
        return list.get(0);
    }

    public boolean isAdmin(int userId) {
        String sql = "SELECT is_admin FROM ADMINS WHERE USERID = ? ";
        final List<Boolean> list = getJdbcTemplate().queryForList(sql, new Object[]{userId}, Boolean.class);
        if (list.isEmpty()) {
            return false;
        }
        return list.get(0);
    }

    public boolean addAdminRights(int userId) {
        try {
            String sql = "INSERT INTO ADMINS (userid, is_admin) VALUES (?, ?)";
            getJdbcTemplate().update(sql, new Object[]{userId, 1});
        } catch (DuplicateKeyException e) {
            logger.warn("User " + userId + "already has admin rights.");
        }
        return true;
    }

    public boolean removeAdminRights(int userId) {
        String sql = "DELETE FROM admins WHERE userid = " + userId;
        getJdbcTemplate().update(sql);
        return true;
    }

    public User find(String login, String pass) {
        String userFind = "SELECT * FROM USERS WHERE LOGIN = '" + login
                + "' AND PASS = '" + pass + "' LIMIT 1";
        final List<User> list = getJdbcTemplate().query(userFind, userMapper);
        return getResultFromList(list);
    }

    public User find(String login) {
        String userFind = "SELECT * FROM USERS WHERE LOGIN = '" + login
                + "' LIMIT 1";
        final List<User> list = getJdbcTemplate().query(userFind, userMapper);
        return getResultFromList(list);
    }

    @Override
    public List<User> getAll() {
        String sql = "SELECT * FROM USERS";
        return getJdbcTemplate().query(sql, userMapper);
    }

    public List<User> getAll(int offset, int limit) {
        if (offset < 0 || limit <= 0) {
            throw new IllegalArgumentException("Arguments limit<=0 or offset<0 not permitted: "
                    + "offset=" + offset + " limit=" + limit);
        }
        String sql = "SELECT * FROM USERS LIMIT " + limit + " OFFSET " + offset;
        return getJdbcTemplate().query(sql, userMapper);
    }

    public int getNumberOfUsers() {
        String sql = "SELECT COUNT(*) FROM USERS";
        return getJdbcTemplate().queryForInt(sql);
    }

    @Override
    public boolean save(final User user) {
        try {
            final String sql = "INSERT INTO USERS "
                    + "(FIRSTNAME, LASTNAME, LOGIN, PASS, EMAIL, BIRTHDAY, PHONENUMBER, PIC_URL) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            KeyHolder keyHolder = new GeneratedKeyHolder();
            getJdbcTemplate().update(new UserStatementCreator(sql, user), keyHolder);
            int id = keyHolder.getKey().intValue();
            user.setId(id);
            return true;
        } catch (DuplicateKeyException e) {
            logger.warn("Tried to insert duplicate key. " + user);
            return false;
        }
    }

    @Override
    public void update(final User user) {
        final String sql = "UPDATE USERS "
                + "SET FIRSTNAME=?, LASTNAME=?, LOGIN=?, PASS=?, EMAIL=?, BIRTHDAY=?, PHONENUMBER=?, PIC_URL=? "
                + " WHERE USERID = " + user.getId();
        getJdbcTemplate().update(new UserStatementCreator(sql, user));
    }

    @Override
    public void delete(User user) {
        String sql = "DELETE FROM USERS WHERE USERID = " + user.getId();
        getJdbcTemplate().update(sql);
    }
    
        public void delete(int userId) {
        String sql = "DELETE FROM USERS WHERE USERID = " + userId;
        getJdbcTemplate().update(sql);
    }

    private User getResultFromList(final List<User> list) {
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    private class UserStatementCreator implements PreparedStatementCreator {

        private final String query;
        private final User user;

        public UserStatementCreator(String sql, User user) {
            this.query = sql;
            this.user = user;
        }

        @Override
        public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getUsername());
            ps.setString(4, user.getPassword());
            ps.setString(5, user.getEmail());
            Date birthday = (user.getBirthday() == null) ? null : new Date(user.getBirthday().getTime());
            ps.setDate(6, birthday);
            ps.setString(7, user.getPhoneNumber());
            ps.setString(8, user.getPicUrl());
            return ps;
        }
    };

    private static class UserMapper implements RowMapper<User> {

        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User(
                    rs.getInt("USERID"),
                    rs.getString("FIRSTNAME"),
                    rs.getString("LASTNAME"),
                    rs.getString("LOGIN"),
                    rs.getString("PASS"),
                    rs.getString("EMAIL"),
                    rs.getDate("BIRTHDAY"),
                    rs.getString("PHONENUMBER"),
                    rs.getString("PIC_URL"));
            return user;
        }
    }
}
