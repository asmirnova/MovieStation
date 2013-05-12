package com.movie.web.controllers;

import com.movie.errors.ResourceNotFoundException;
import com.movie.pers.entities.Movie;
import com.movie.web.service.MovieService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Aloren
 */
@Controller
public class MovieController {

    private final static int FIRST_PAGE = 1;
    private final static int DEFAULT_MAX_PER_PAGE = 5;
    private final static int MAX_PER_PAGE = 50;
    @Autowired
    private MovieService movieService;
    private Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "/movies", method = RequestMethod.GET)
    public String getMovies(Model model) {
        return processMoviesListRequest(DEFAULT_MAX_PER_PAGE, FIRST_PAGE, model);
    }

    @RequestMapping(value = "/movies/{numPage}/{max}", method = RequestMethod.GET)
    public String getMoviesForPage(@PathVariable("numPage") Integer page,
            @PathVariable("max") Integer maxPerPage, Model model) {
        if (maxPerPage > MAX_PER_PAGE) {
            maxPerPage = MAX_PER_PAGE;
        }
        return processMoviesListRequest(maxPerPage, page, model);
    }

    @RequestMapping(value = "/movie/{id}", method = RequestMethod.GET)
    public String getMovieData(@PathVariable("id") Integer movieId, Model model) {
        Movie movie = movieService.findById(movieId);
        if (movie == null) {
            logger.warn("No movie found for id " + movieId);
            throw new ResourceNotFoundException("Sorry. no such film!");
        }
        model.addAttribute("movie", movie);
        return "movies/movie";
    }

    private String processMoviesListRequest(int maxPerPage, int page, Model model) {
        int numberOfPages = movieService.getNumberOfMoviePages(maxPerPage);
        List<Movie> movies = movieService.findAll(page, maxPerPage);
        model.addAttribute("movies", movies);
        model.addAttribute("numPages", numberOfPages);
        model.addAttribute("curPage", page);
        return "movies/list";
    }
}
