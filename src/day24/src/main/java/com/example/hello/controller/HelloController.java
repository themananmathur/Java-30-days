package com.example.hello.controller;

import com.example.hello.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class HelloController {

    private final GreetingService greetingService;

    @Autowired
    public HelloController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }
    
    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }

    @GetMapping("/hello/{name}")
    public String helloName(@PathVariable("name") String name) {
        return greetingService.helloName(name);
    }

    // tiny DTOs using Java record (Java 16+)
    public record GreetRequest(String name) {}
    public record GreetResponse(String message) {}

    @PostMapping("/greet")
    public GreetResponse greet(@RequestBody GreetRequest req) {
        String msg = (req.name() == null || req.name().isBlank()) ? "Hello, stranger!" : "Hello, " + req.name() + "!";
        return new GreetResponse(msg);
    }
}
