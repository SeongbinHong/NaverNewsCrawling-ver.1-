package com.example.demo.domain.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {
    @GetMapping("/")
    public String init(){
        return "Server Started!!";
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello, World";
    }
}
