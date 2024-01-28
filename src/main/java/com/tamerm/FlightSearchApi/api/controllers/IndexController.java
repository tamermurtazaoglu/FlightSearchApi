package com.tamerm.FlightSearchApi.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @GetMapping("")
    public String index(){
        return "<h1>Welcome</h1>" +
                "<p>for login page <a href='/login'>click</a>" +
                "or use any api end point like <a href='/airports/all'>that</a></p>";
    }
}
