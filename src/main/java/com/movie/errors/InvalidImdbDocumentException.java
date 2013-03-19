package com.movie.errors;

/**
 *
 * @author Aloren
 */
public class InvalidImdbDocumentException extends MovieException {
    
    public InvalidImdbDocumentException(String mes, Throwable t){
        super(mes, t);
    }
    
}
