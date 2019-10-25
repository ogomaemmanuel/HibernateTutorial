package com.ogoma.authserver.services;

import com.ogoma.authserver.enitities.User;
import com.ogoma.authserver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository=userRepository;
    }

    public User save(User user){
        user=  this.userRepository.save(user);
        return user;
    }

    public  Long count(){
        return userRepository.count();
    }
}
