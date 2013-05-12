package com.movie.errors;

/**
 *
 * @author Aloren
 */
public enum Error {

    OK(0, "No error"),
    INVALID_DOC(1, "Invalid Imdb-document"),
    LOGIN_BUSY(500, "User with such login already exists"),
    BAD_LOGIN(501, "Bad login"),
    BAD_PASS(502, "Bad password"),
    BAD_EMAIL(503, "Bad email"),
    BAD_BIRTH(504, "Bad birthday"),
    BAD_PHONE(505, "Bad phone number"),
    LONG_PHONE(506, "Too long phone number");
    private int errorCode;
    private String description;

    private Error(int errorCode, String desc) {
        this.errorCode = errorCode;
        this.description = desc;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getDescription() {
        return description;
    }
}
