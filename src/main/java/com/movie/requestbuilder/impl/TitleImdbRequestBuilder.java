package com.movie.requestbuilder.impl;

import com.movie.requestbuilder.ImdbRequestBuilder;

/**
 *
 * @author Aloren
 */
public class TitleImdbRequestBuilder extends ImdbRequestBuilder {

    public TitleImdbRequestBuilder(String title) {
        super("q", title);
    }
    
}
