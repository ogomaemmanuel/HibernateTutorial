package com.ogoma.resourceserver.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping(value = "/")
    public String Index(){
        return "index";
    }

    @RequestMapping(value = "/login")
    public String ssoLogin(){
        return "login";
    }
}
