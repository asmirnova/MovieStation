package com.movie.web.context;

import com.movie.pers.entities.User;
import com.movie.web.auth.AuthorityCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Collection;
import javax.validation.constraints.NotNull;


@Component
public class SpringSecurityUserContext implements UserContext {
    
    @Autowired
    @NotNull
    private AuthorityCreator authorityCreator;

    @Override
    public User getCurrentUser() {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        if (authentication == null) {
            return null;
        }
        
        return (User) authentication.getPrincipal();
    }

    @Override
    public void setCurrentUser(@NotNull User user) {
        Collection<? extends GrantedAuthority> authorities = authorityCreator.createAuthorities(user);
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user,
                user.getPassword(),authorities);
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}
