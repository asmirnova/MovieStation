package com.movie.requestbuilder.impl;

import com.movie.requestbuilder.ImdbRequestBuilder;
import com.movie.xml.types.MovieType;

/**
 *
 * @author Aloren
 */
public class IdImdbRequestBuilder extends ImdbRequestBuilder {

    public IdImdbRequestBuilder(String id) {
        //TODO check id with regexp /^tt\d+$/
        super("id", id);
    }

    public ImdbRequestBuilder year(int year) {
        throw new UnsupportedOperationException();
    }

    public ImdbRequestBuilder year(boolean year) {
        throw new UnsupportedOperationException();
    }

    public ImdbRequestBuilder movieType(MovieType movieType) {
        throw new UnsupportedOperationException();
    }

    public ImdbRequestBuilder limit(int limit) {
        throw new UnsupportedOperationException();
    }


}
