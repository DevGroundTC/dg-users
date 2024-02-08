package com.example.dgusers.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class HealthCheckController {
    @GetMapping("/healthcheck")
    public String returnOK() {
        return "OK";
    }
}
