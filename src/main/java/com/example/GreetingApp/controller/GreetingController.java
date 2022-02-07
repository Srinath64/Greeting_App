package com.example.GreetingApp.controller;

import com.example.GreetingApp.entity.Greeting;
import com.example.GreetingApp.entity.User;
import com.example.GreetingApp.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

//    private static final String template = "Hello, %s!";
//    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private GreetingService greetingService;

    @GetMapping(value = {"", "/"})
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name){
//        return new Greeting(counter.incrementAndGet(), String.format(template, name));
        User user = new User();
        user.setFirstName(name);
        return greetingService.addGreeting(user);
    }
}
