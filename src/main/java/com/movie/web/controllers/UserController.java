package com.movie.web.controllers;

import com.movie.errors.ResourceNotFoundException;
import com.movie.pers.entities.Movie;
import com.movie.pers.entities.User;
import com.movie.web.service.UserService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
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
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/profile/user/{id}", method = RequestMethod.GET)
    public String showProfile(@PathVariable("id") Integer id,
            HttpServletRequest request, Model model) {
        User foundUser = userService.findById(id);
        if (foundUser == null) {
            throw new ResourceNotFoundException();
        } else {
            List<Movie> favorites = userService.getUserFavoriteMovies(id);
            foundUser.setFavorites(favorites);
            model.addAttribute("user", foundUser);
        }
        return "profile";
    }

}
