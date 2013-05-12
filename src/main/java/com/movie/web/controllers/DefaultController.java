package com.movie.web.controllers;

import javax.servlet.http.HttpServletRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Aloren
 */
@Controller
public class DefaultController {

    @RequestMapping("/default")
    public String defaultAfterLogin(HttpServletRequest request) {
        System.out.println("Logged in user " + SecurityContextHolder.getContext().getAuthentication());
        if (request.isUserInRole("ROLE_ADMIN")) {
            System.out.println("Redirecting admin to admin page");
            return "redirect:/admin";
        }
        System.out.println("Redirecting to /");
        return "redirect:/";
    }
}
