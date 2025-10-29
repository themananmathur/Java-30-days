package com.day30.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/")
    public String home() {
        return "Day 30 — Dockerized Spring Boot app is running";
    }

    @GetMapping("/api/hello")
    public String hello() {
        return "hello from day30";
    }
}
