package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Value("${spring.profiles.active}")
    private String activeProfile;

    @RequestMapping("/test")
    public String test() {
        return "hello java";
    }

    @GetMapping("/ping")
    public String ping() {
        return activeProfile;
    }
}
