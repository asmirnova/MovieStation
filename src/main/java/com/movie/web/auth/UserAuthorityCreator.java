package com.movie.web.auth;

import com.movie.pers.entities.User;
import com.movie.web.service.UserService;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

/**
 * A utility class used for creating the {@link GrantedAuthority}'s given a
 * {@link CalendarUser}. In a real solution this would be looked up in the
 * existing system, but for simplicity our original system had no notion of
 * authorities.
 *
 * @author Rob Winch
 *
 */
public final class UserAuthorityCreator implements AuthorityCreator {

    private static final List<GrantedAuthority> ADMIN_ROLES =
            AuthorityUtils.createAuthorityList("ROLE_ADMIN", "ROLE_USER");
    private static final List<GrantedAuthority> USER_ROLES =
            AuthorityUtils.createAuthorityList("ROLE_USER");
    @Autowired
    private UserService userService;

    private UserAuthorityCreator() {
    }

    @Override
    public Collection<? extends GrantedAuthority> createAuthorities(User user) {
        String username = user.getUsername();
        boolean isAdmin = userService.isAdmin(username);
        if (isAdmin) {
            return ADMIN_ROLES;
        }
        return USER_ROLES;
    }
}
