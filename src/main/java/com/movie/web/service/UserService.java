package com.movie.web.service;

import com.movie.pers.entities.Favorite;
import com.movie.pers.entities.Movie;
import com.movie.pers.entities.User;
import com.movie.pers.jdbc.dao.impl.FavoriteDao;
import com.movie.pers.jdbc.dao.impl.UserDao;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Aloren
 */
public class UserService implements BaseService<User> {

    @Autowired
    private UserDao userDao;
    @Autowired
    private FavoriteDao favoriteDao;

    @Override
    public void add(User user) {
        userDao.save(user);
    }

    @Override
    public User findById(int userId) {
        return userDao.getById(userId);
    }

    public User findByUsername(String username) {
        return userDao.find(username);
    }

    public boolean isAdmin(int userId) {
        return userDao.isAdmin(userId);
    }

    public boolean isAdmin(String userName) {
        return userDao.isAdmin(userName);
    }

    @Override
    public void delete(User user) {
        userDao.delete(user);
    }

    public void deleteById(int userId) {
        userDao.delete(userId);
    }

    public boolean tryRegister(User user) {
        User userInDb = userDao.find(user.getUsername());
        if (userInDb == null) {
            userDao.save(user);
            return true;
        }
        return false;
    }

    public void addAdminRights(int userId) {
        userDao.addAdminRights(userId);
    }

    public void removeAdminRights(int userId) {
        userDao.removeAdminRights(userId);
    }

    public void addUserFavorite(int userId, Movie movie) {
        Favorite fav = new Favorite(userId, movie);
        favoriteDao.save(fav);
    }

    public void removeUserFavorite(int userId, Movie movie) {
        Favorite fav = new Favorite(userId, movie);
        favoriteDao.delete(fav);
    }

    public List<Movie> getUserFavoriteMovies(int userId) {
        List<Favorite> favorites = favoriteDao.getAll(userId);
        List<Movie> movies = new ArrayList<>();
        for (Favorite fav : favorites) {
            Movie movie = fav.getMovie();
            movies.add(movie);
        }
        return movies;
    }

    @Override
    public List<User> findAll() {
        return userDao.getAll();
    }

    public List<User> findAll(int page, int maxPerPage) {
        int offset = (page - 1) * maxPerPage;
        return userDao.getAll(offset, maxPerPage);
    }

    public int getNumberOfUserPages(int maxPerPage) {
        int numberOfUsers = userDao.getNumberOfUsers();
        return (int) Math.ceil(numberOfUsers * 1.0 / maxPerPage);
    }
}
