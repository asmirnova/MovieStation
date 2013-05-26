package com.movie.pers.entities;

import java.util.Objects;

/**
 *
 * @author Aloren
 */
public class Favorite {

    private Integer userId;
    private Movie movie;

    public Favorite() {
    }

    public Favorite(Integer userId, Movie movie) {
        this.userId = userId;
        this.movie = movie;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.userId);
        hash = 67 * hash + Objects.hashCode(this.movie);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Favorite other = (Favorite) obj;
        if (!Objects.equals(this.userId, other.userId)) {
            return false;
        }
        return Objects.equals(this.movie, other.movie);
    }
    
    @Override
    public String toString() {
        return "Favorite{" + "userId=" + userId + ", movie=" + movie + '}';
    }
}
