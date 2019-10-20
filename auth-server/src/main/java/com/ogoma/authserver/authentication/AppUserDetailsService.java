package com.ogoma.authserver.authentication;

import com.ogoma.authserver.enitities.User;
import com.ogoma.authserver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class AppUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user= userRepository.findByEmail(s);
        if (user==null){
            throw new UsernameNotFoundException("User does not exists");
        }
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),user.getPassword(),new ArrayList<>()
        );
    }
}
