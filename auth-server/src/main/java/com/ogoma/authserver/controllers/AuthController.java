package com.ogoma.authserver.controllers;

import com.ogoma.authserver.enitities.User;
import com.ogoma.authserver.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class AuthController {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "user/register")
    public ResponseEntity registerUser(@RequestBody @Valid User user){
       User savedUser= this.userService.save(user);
       return ResponseEntity.ok(savedUser);
    }
}
