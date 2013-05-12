package com.movie.pers.entities;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Aloren
 */
public class Movie {

    private Integer id;
    private String title;
    private float rating;
    private int year;
    private String imdbUrl;
    private String plotSimple;
    private String posterUrl;
    private String imdbId;
    private Date releaseDate;

    public Movie() {
    }

    public Movie(String title, float rating, int year,
            String imdbUrl, String plotSimple, String posterUrl, String imdbId,
            Date releaseDate) {
        this(null, title, rating, year, imdbUrl, plotSimple, posterUrl, imdbId, releaseDate);
    }

    public Movie(Integer id, String title, float rating, int year,
            String imdbUrl, String plotSimple, String posterUrl, String imdbId,
            Date releaseDate) {
        this.id = id;
        this.title = title;
        this.rating = rating;
        this.year = year;
        this.imdbUrl = imdbUrl;
        this.plotSimple = plotSimple;
        this.posterUrl = posterUrl;
        this.imdbId = imdbId;
        this.releaseDate = releaseDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getImdbUrl() {
        return imdbUrl;
    }

    public void setImdbUrl(String imdbUrl) {
        this.imdbUrl = imdbUrl;
    }

    public String getPlotSimple() {
        return plotSimple;
    }

    public void setPlotSimple(String plotSimple) {
        this.plotSimple = plotSimple;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.title);
        hash = 97 * hash + this.year;
        hash = 97 * hash + Objects.hashCode(this.imdbId);
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
        final Movie other = (Movie) obj;
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (this.year != other.year) {
            return false;
        }
        if (!Objects.equals(this.imdbId, other.imdbId)) {
            return false;
        }
        return true;
    }

//    @Override
//    public String toString() {
//        return "Movie{" + "id=" + id + ", title=" + title + ", rating=" + rating + ", year=" + year + ", imdbUrl=" + imdbUrl + ", plotSimple=" + plotSimple + ", posterUrl=" + posterUrl + ", imdbId=" + imdbId + ", releaseDate=" + releaseDate + '}';
//    }
}
