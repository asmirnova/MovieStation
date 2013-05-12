package com.movie.web.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Aloren
 */
public class LoggingHandlerExceptionResolver implements HandlerExceptionResolver, Ordered {
    
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public ModelAndView resolveException(HttpServletRequest hsr,
            HttpServletResponse hsr1, Object o, Exception exception) {
        logger.error("Exception occured.",exception);
        return new ModelAndView("errors/404");
    }
    
    @Override
    public int getOrder() {
        return Integer.MIN_VALUE;
    }
}
