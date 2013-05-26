package com.movie.pers.jdbc.dao.impl;

import com.movie.pers.entities.Comment;
import com.movie.pers.entities.Favorite;
import com.movie.pers.entities.Movie;
import com.movie.pers.entities.User;
import org.joda.time.DateTime;

/**
 *
 * @author Aloren
 */
public class TestData {

    public static final Movie testMovie1 = new Movie(1, "Harry Potter", 7.8f, 2006,
            "harry-potter.com", "Blablabla", "poster.url.test",
            "tt123456", new DateTime(2003, 3, 3, 0, 0).toDate());
    public static final Movie testMovie2 = new Movie(2, "Tanya Grotter", 6.5f, 2007,
            "tanya-grotter.com", "Blablabla", "poster.tanya.jpg",
            "tt438674", new DateTime(2005, 7, 25, 0, 0).toDate());
    
    public static final User testUser1 = new User(1, "Nastya", "Smirnova",
            "aloren", "pass", "email@gmail.com", new DateTime(1991, 9, 20, 0, 0).toDate(), "51575");
    public static final User testUser2 = new User(2, "Vasya", "Pupkin",
            "login", "pass", "test@gmail.com", new DateTime(1786, 5, 7, 0, 0).toDate(), "65988794");
    
    public static final Favorite testFavorite1 = new Favorite(testUser1.getId(), testMovie1);
    public static final Favorite testFavorite2 = new Favorite(testUser1.getId(), testMovie2);
    public static final Favorite testFavorite3 = new Favorite(testUser2.getId(), testMovie2);
    
    public static final Comment testComment1 = new Comment(1, "title1", "text1", 1, 1, 1.0f);
    public static final Comment testComment2 = new Comment(2, "title2", "text2", 1, 2, 2.0f);
}
