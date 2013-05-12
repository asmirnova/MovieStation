package com.movie.web.service;

import com.movie.pers.entities.User;

public interface UserContext {

    User getCurrentUser();

    void setCurrentUser(User user);
}
