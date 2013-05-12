package com.movie.web.controllers;

import com.movie.pers.entities.Comment;
import com.movie.web.service.CommentService;
import com.movie.web.service.UserContext;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Aloren
 */
@Controller
public class CommentController {

    private final static int FIRST_PAGE = 1;
    private final static int DEFAULT_MAX_PER_PAGE = 5;
    private final static int MAX_PER_PAGE = 50;
    @Autowired
    private CommentService commentService;
    @Autowired
    private UserContext userContext;
    private Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "/getComments/{movieId}", method = RequestMethod.GET)
    @ResponseBody
    public CommentData getComments(@PathVariable("movieId") int movieId) {
        CommentData comments = processCommentsRequest(movieId, FIRST_PAGE, DEFAULT_MAX_PER_PAGE);
        System.out.println("Returning data with comments");
        return comments;
    }

    @RequestMapping(value = "/getComments/{movieId}/{page}/{max}", method = RequestMethod.GET)
    @ResponseBody
    public CommentData getCommentsForPage(@PathVariable("movieId") int movieId,
            @PathVariable("page") int page, @PathVariable("max") int maxPerPage) {
        if (maxPerPage > MAX_PER_PAGE) {
            maxPerPage = MAX_PER_PAGE;
        }
        CommentData comments = processCommentsRequest(movieId, page, maxPerPage);
        return comments;
    }

    @RequestMapping(value = "/deleteComment/{commentId}", method = RequestMethod.GET)
    public String deleteComment(@PathVariable("commentId") int commentId,
            HttpServletRequest request) {
        String referer = request.getHeader("Referer");
        int owner = commentService.getCommentOwnerId(commentId);
        if (owner == userContext.getCurrentUser().getId()) {
            commentService.deleteById(commentId);
        }
        return "redirect:" + referer;
    }

    private CommentData processCommentsRequest(int movieId, int page, int maxPerPage) {
        int numberOfPages = commentService.getNumberOfCommentPages(maxPerPage, movieId);
        List<Comment> comments = commentService.getCommentsForMovie(movieId, page, maxPerPage);
        CommentData commentData = new CommentData(page, numberOfPages, comments);
        return commentData;
    }

    public static class CommentData {

        private int currentPage;
        private int numberOfPages;
        private List<Comment> comments;

        public CommentData(int currentPage, int numberOfPages, List<Comment> comments) {
            this.currentPage = currentPage;
            this.numberOfPages = numberOfPages;
            this.comments = comments;
        }

        public int getCurrentPage() {
            return currentPage;
        }

        public void setCurrentPage(int currentPage) {
            this.currentPage = currentPage;
        }

        public int getNumberOfPages() {
            return numberOfPages;
        }

        public void setNumberOfPages(int numberOfPages) {
            this.numberOfPages = numberOfPages;
        }

        public List<Comment> getComments() {
            return comments;
        }

        public void setComments(List<Comment> movies) {
            this.comments = movies;
        }
    }
}
