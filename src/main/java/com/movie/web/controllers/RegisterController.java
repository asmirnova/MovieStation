package com.movie.web.controllers;

import com.movie.pers.entities.User;
import com.movie.web.controllers.utils.UserFiller;
import com.movie.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.movie.web.form.SignupForm;
import com.movie.web.service.UserContext;
import javax.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Aloren
 */
@Controller
public class RegisterController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserContext userContext;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String loginGet(@ModelAttribute SignupForm signupForm) {
        return "register";
    }
    
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerPost(@Valid SignupForm signupForm, 
            BindingResult result, RedirectAttributes redirectAttributes, 
            Model model) {
        User user = UserFiller.fillFromForm(signupForm);
        if (result.hasErrors()) {
            model.addAttribute("user", user);
            model.addAttribute("errors", result.getAllErrors());
            return "/register";
        }
        boolean registered = userService.tryRegister(user);
        if (registered) {
            userContext.setCurrentUser(user);
            redirectAttributes.addFlashAttribute("message",
                    "You have successfully signed up and logged in.");
            return "redirect:/";
        } else {
            model.addAttribute("user", user);
            result.addError(new ObjectError("username", "Username is already in use."));
            model.addAttribute("errors", result.getAllErrors());
            return "register";
        }
    }

}
