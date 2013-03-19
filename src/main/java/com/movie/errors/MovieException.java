package com.movie.errors;

/**
 *
 * @author Aloren
 */
public class MovieException extends RuntimeException {

    public MovieException(String message, Throwable e) {
        super(message, e);
    }
}
