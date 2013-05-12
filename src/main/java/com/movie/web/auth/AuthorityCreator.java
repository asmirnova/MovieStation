package com.movie.web.auth;

import com.movie.pers.entities.User;
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author Aloren
 */
public interface AuthorityCreator {

    Collection<? extends GrantedAuthority> createAuthorities(User user);
    
}
