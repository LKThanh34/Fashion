package com.ktsoft.fashion.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class HelloController {

    @GetMapping("/")    
    public String getHelloWorld(){
        return "hello";
    }
    
}
