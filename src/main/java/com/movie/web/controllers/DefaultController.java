package com.movie.web.controllers;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Aloren
 */
@Controller
public class DefaultController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping("/default")
    public String defaultAfterLogin(HttpServletRequest request) {
        logger.info("Logged in user " + SecurityContextHolder.getContext().getAuthentication());
        if (request.isUserInRole("ROLE_ADMIN")) {
            logger.info("Redirecting admin to admin page");
            return "redirect:/admin";
        }
        logger.info("Redirecting to /");
        return "redirect:/";
    }
}