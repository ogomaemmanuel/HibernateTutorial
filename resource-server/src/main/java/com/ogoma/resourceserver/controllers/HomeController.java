package com.ogoma.resourceserver.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
public class HomeController {
    @RequestMapping(value = "/")
    public String Index(){
        return "index";
    }

    @RequestMapping(value = "/user")
    @ResponseBody
    public Principal ssoLogin(Principal  principal){
        //System.out.println("Authentiocated principal"+principal.toString());
        return principal;
    }
}
