package com.movie.web.service;

import com.movie.pers.entities.User;
import com.movie.web.auth.AuthorityCreator;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;


@Component
public class SpringSecurityUserContext implements UserContext {
    
    @Autowired
    private AuthorityCreator authorityCreator;

    @Override
    public User getCurrentUser() {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        System.out.println("Authentication "+authentication);
        System.out.println("Principal: "+((UsernamePasswordAuthenticationToken)authentication).getPrincipal());
        if (authentication == null) {
            System.out.println("Returning null");
            return null;
        }
        
        return (User) authentication.getPrincipal();
    }

    @Override
    public void setCurrentUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("user cannot be null");
        }
        Collection<? extends GrantedAuthority> authorities = authorityCreator.createAuthorities(user);
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user,
                user.getPassword(),authorities);
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}
