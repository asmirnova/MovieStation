package com.movie.validator;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Aloren
 */
public class UserValidatorTest {

    @Test
    public void validateEmail() {
        List<String> validPhones = Arrays.asList("+1234", "1234", "12345123451234", "123456", "+12345123451234");
        for (String phone : validPhones) {
            boolean isValid = UserValidator.isValidPhoneNumber(phone);
            assertTrue(isValid);
        }

    }
}
