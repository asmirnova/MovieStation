package com.movie.web.controllers;

import com.movie.errors.ResourceNotFoundException;
import com.movie.pers.entities.User;
import com.movie.web.controllers.utils.UserFiller;
import com.movie.web.form.SignupForm;
import com.movie.web.service.UserService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Aloren
 */
@RequestMapping("/admin")
@Controller
public class AdminController {

    private final static int FIRST_PAGE = 1;
    private final static int DEFAULT_MAX_PER_PAGE = 5;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String listUsersFirstPage(Model model) {
        return processUsersListRequest(DEFAULT_MAX_PER_PAGE, FIRST_PAGE, model);
    }

    @RequestMapping(value = "/users/{numPage}/{max}", method = RequestMethod.GET)
    public String listUsersPerPage(@PathVariable("numPage") Integer page,
            @PathVariable("max") Integer maxPerPage, Model model) {
        return processUsersListRequest(maxPerPage, page, model);
    }

    @RequestMapping(value = "/users/setAdmin/{userId}", method = RequestMethod.GET)
    public String addAdminRights(@PathVariable("userId") int userId,
            HttpServletRequest request) {
        String referer = request.getHeader("Referer");
        User user = userService.findById(userId);
        if (user != null) {
            System.out.println("Adding admin rights for " + userId);
            userService.addAdminRights(userId);
            return "redirect:" + referer;
        }
        throw new ResourceNotFoundException("No such user!");
    }

    @RequestMapping(value = "/users/isAdmin/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public boolean isAdmin(@PathVariable("userId") int userId) {
        User user = userService.findById(userId);
        if (user != null) {
            System.out.println("Checking admin rights for " + userId);
            return userService.isAdmin(userId);
        }
        throw new ResourceNotFoundException("No such user!");
    }

    @RequestMapping(value = "/users/unsetAdmin/{userId}", method = RequestMethod.GET)
    public String removeAdminRights(@PathVariable("userId") int userId,
            HttpServletRequest request) {
        String referer = request.getHeader("Referer");
        User user = userService.findById(userId);
        if (user != null) {
            System.out.println("Removing admin rights for " + userId);
            userService.removeAdminRights(userId);
            return "redirect:" + referer;
        }
        throw new ResourceNotFoundException("No such user!");
    }

    @RequestMapping(value = "/users/removeUser/{userId}", method = RequestMethod.GET)
    public String removeUser(@PathVariable("userId") int userId) {
        User user = userService.findById(userId);
        if (user != null) {
            System.out.println("Removing user " + userId);
            userService.deleteById(userId);
            return "redirect:/admin/users";
        }
        throw new ResourceNotFoundException("No such user!");
    }

    @RequestMapping(value = "/users/create", method = RequestMethod.POST)
    public String createUser(@Valid SignupForm signupForm, BindingResult result,
            RedirectAttributes redirectAttributes, Model model) {
        User user = UserFiller.fillFromForm(signupForm);
        if (result.hasErrors()) {
            model.addAttribute("user", user);
            model.addAttribute("errors", result.getAllErrors());
            return "/register";
        }
        boolean registered = userService.tryRegister(user);
        if (registered) {
            return "redirect:/";
        } else {
            model.addAttribute("user", user);
            result.addError(new ObjectError("username", "Username is already in use."));
            model.addAttribute("errors", result.getAllErrors());
            return "register";
        }
    }

    private String processUsersListRequest(int maxPerPage, int page, Model model) {
        int numberOfPages = userService.getNumberOfUserPages(maxPerPage);
        List<User> allUsers = userService.findAll(page, maxPerPage);
        model.addAttribute("users", allUsers);
        model.addAttribute("numPages", numberOfPages);
        model.addAttribute("curPage", page);
        return "users/list";
    }
}
