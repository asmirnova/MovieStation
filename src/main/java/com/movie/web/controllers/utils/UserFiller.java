package com.movie.web.controllers.utils;

import com.movie.pers.entities.User;
import com.movie.web.form.SignupForm;

/**
 *
 * @author Aloren
 */
public class UserFiller {

    public static User fillFromForm(SignupForm f) {
        User user = new User(f.getFirstName(), f.getLastName(),
                f.getUsername(), f.getPassword(),
                f.getEmail(), f.getBirthday(), f.getPhoneNumber(), f.getPicUrl());
        return user;
    }
}
