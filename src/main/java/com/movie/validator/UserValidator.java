package com.movie.validator;

import com.movie.pers.entities.User;
import java.util.List;
import java.util.regex.Pattern;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.validator.EmailValidator;
import com.movie.errors.Error;
import java.util.ArrayList;

/**
 *
 * @author Aloren
 */
public class UserValidator {

    private static final Pattern phonePattern = Pattern.compile("\\+?\\d{4,14}|\\d{4,15}");

    public static List<Error> validateUser(User user) {
        List<Error> errors = new ArrayList<>();
        final String login = user.getUsername();
        if (StringUtils.isEmpty(login)) {
            errors.add(Error.BAD_LOGIN);
        }
        final String pass = user.getPassword();
        if (StringUtils.isEmpty(pass)) {
            errors.add(Error.BAD_PASS);
        }
        final String email = user.getEmail();
        if (!isValidEmail(email)) {
            errors.add(Error.BAD_EMAIL);
        }
        final String phoneNumber = user.getPhoneNumber();
        if (!isValidPhoneNumber(phoneNumber)) {
            System.out.println("Phone number: "+phoneNumber+" is not valid!!");
            errors.add(Error.BAD_PHONE);
        }
        return errors;
    }

    protected static boolean isValidEmail(String email) {
        if (!EmailValidator.getInstance().isValid(email)) {
            return false;
        }
        return true;
    }

    protected static boolean isValidPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || !phonePattern.matcher(phoneNumber).matches()) {
            return false;
        }
        return true;
    }
}
