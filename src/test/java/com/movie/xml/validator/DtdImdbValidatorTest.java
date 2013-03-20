package com.movie.xml.validator;

import com.movie.errors.ErrorMessages;
import com.movie.errors.InvalidImdbDocumentException;
import com.movie.errors.MovieException;
import com.movie.xml.utils.ResponseUtils;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Aloren
 */
public class DtdImdbValidatorTest {

    private DtdImdbValidator validator;

    @Before
    public void setup() {
        this.validator = new DtdImdbValidator();
    }

    @Test
    public void normalResponse() {
        try {
            validator.validate(ResponseUtils.convertToString(ResponseUtils.createIdImdbDocument()));
        } catch (MovieException e) {
            fail("Expected no exception, but got:" + e);
        }
    }

    @Ignore(value = "Not implemented yet")
    @Test
    public void misOrderedResponse() {
        //TODO add logic here
    }

    @Test
    public void notAllParamsResponse() {
        final String resp = ResponseUtils.convertToString(ResponseUtils.createBadIdImdbDocument());
        try {
            validator.validate(resp);
        } catch (InvalidImdbDocumentException ex) {
            assertTrue("", ex.getMessage().equals(ErrorMessages.INVALID_DOC));
        }
    }

    @Test
    public void emptyResponse() {
        final String resp = ResponseUtils.convertToString(ResponseUtils.createEmptyIdImdbDocument());
        try {
            validator.validate(resp);
        } catch (InvalidImdbDocumentException ex) {
            assertTrue("", ex.getMessage().equals(ErrorMessages.INVALID_DOC));
        }
    }
}
