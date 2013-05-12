package com.movie.errors;

/**
 *
 * @author Aloren
 */
public class InvalidImdbDocumentException extends MovieException {
    
    public InvalidImdbDocumentException(Error error, Throwable t){
        super(error, t);
    }
    
}
