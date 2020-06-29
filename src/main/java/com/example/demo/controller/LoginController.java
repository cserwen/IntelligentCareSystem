package com.example.demo.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(allowCredentials="true",maxAge = 3600)
public class LoginController {

    @RequestMapping("/login")
    public String login(){
        return "hello world";
    }
}
