package com.movie.web.service;

import com.movie.pers.entities.Comment;
import com.movie.pers.jdbc.dao.impl.CommentDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Aloren
 */
public class CommentService implements BaseService<Comment>{
    
    @Autowired
    private CommentDao commentDao;

    @Override
    public void add(Comment comment) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Comment comment) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Comment findById(int commentId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Comment> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Comment> getCommentsForMovie(int movieId) {
        return commentDao.getAllForMovie(movieId);
    }

    public int getNumberOfCommentPages(int maxPerPage, int movieId) {
        int numberOfComments = commentDao.getNumberOfCommentsForMovie(movieId);
        return (int) Math.ceil(numberOfComments * 1.0 / maxPerPage);
    }

    public List<Comment> getCommentsForMovie(int movieId, int page, int maxPerPage) {
        int offset = (page - 1) * maxPerPage;
        return commentDao.getAllForMovie(movieId, offset, maxPerPage);
    }

    public int getCommentOwnerId(int commentId) {
        //TODO add method for getting only userId
        return commentDao.getById(commentId).getUserId();
    }

    public void deleteById(int commentId) {
        commentDao.delete(commentId);
    }
}
