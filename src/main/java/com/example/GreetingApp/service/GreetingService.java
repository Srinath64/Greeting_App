package com.example.GreetingApp.service;

import com.example.GreetingApp.entity.Greeting;
import com.example.GreetingApp.entity.User;

public interface GreetingService {
    Greeting addGreeting(User user);

    Greeting getGreetingById(long id);

    Greeting updateGreeting(long id, User user);

    Greeting deleteGreeting(Long id);
}
