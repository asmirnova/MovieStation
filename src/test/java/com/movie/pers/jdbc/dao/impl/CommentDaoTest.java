package com.movie.pers.jdbc.dao.impl;

import com.movie.pers.entities.Comment;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.*;

/**
 *
 * @author Aloren
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/resources/web/application-context.xml"})
@ActiveProfiles("test")
public class CommentDaoTest extends BaseDaoTest {

    public static final Comment testComment1 = TestData.testComment1;//1 - 1
    public static final Comment testComment2 = TestData.testComment2;// 1 -  2
    private static final int NUM_TEST_ROWS = 2;
    @Autowired
    private CommentDao commentDao;

    @Test
    public void getAllCommentsForMovie() {
        List<Comment> comments = commentDao.getAllForMovie(testComment1.getMovieId());
        final int numComments = comments.size();
        final int expectedNumComments = 1;
        assertTrue("Expected " + expectedNumComments + ", but was " + numComments, numComments == expectedNumComments);
        assertEquals(testComment1, comments.get(0));
    }
    
    @Test
    public void getAllCommentsForUser() {
        List<Comment> comments = commentDao.getAllForUser(testComment1.getUserId());
        final int numComments = comments.size();
        final int expectedNumComments = NUM_TEST_ROWS;
        assertTrue("Expected " + expectedNumComments + ", but was " + numComments, numComments == expectedNumComments);
        assertEquals(testComment1, comments.get(0));
        assertEquals(testComment2, comments.get(1));
    }
    
    @Test
    public void getEmptyComments() {
        List<Comment> commentsForUnexistentUser = commentDao.getAllForUser(100);
        assertTrue(commentsForUnexistentUser.isEmpty());
        List<Comment> commentsForUnexistentMovie = commentDao.getAllForMovie(100);
        assertTrue(commentsForUnexistentMovie.isEmpty());
        
    }

    @Test
    public void getCommentById() {
        Comment comment = commentDao.getById(testComment1.getId());
        assertEquals(testComment1, comment);
    }
}
