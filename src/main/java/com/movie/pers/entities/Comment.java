package com.movie.pers.entities;

/**
 *
 * @author Aloren
 */
public class Comment {

    private int id;
    private String text;
    private String title;
    private int userId;
    private int movieId;
    private float rating;

    public Comment() {
    }

    public Comment(int id, String title, String text, int userId, int movieId, float rating) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.userId = userId;
        this.movieId = movieId;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.id;
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
        final Comment other = (Comment) obj;
        return this.id == other.id;
    }
    
    @Override
    public String toString() {
        return "Comment{" + "id=" + id + ", text=" + text + ", title=" + title + ", userId=" + userId + ", movieId=" + movieId + ", rating=" + rating + '}';
    }
}
