package com.movie.errors;

/**
 *
 * @author Aloren
 */
public class MovieException extends RuntimeException {

    private Error error;

    public MovieException(Error error, Throwable e) {
        super(error.getDescription(), e);
        this.error = error;
    }
    
    public Error getError() {
        return error;
    }
    
}
