package com.example.hello.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    public String hello() {
        return "Hello, World!";
    }

    public String helloName(String name) {
        if (name == null || name.isBlank()) return "Hello, stranger!";
        return "Hello, " + name + "!";
    }

    public String greetFromRequest(String name) {
        return helloName(name);
    }
}
