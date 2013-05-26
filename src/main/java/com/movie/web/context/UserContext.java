package com.movie.web.context;

import com.movie.pers.entities.User;

public interface UserContext {

    User getCurrentUser();

    void setCurrentUser(User user);
}
