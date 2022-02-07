package com.example.GreetingApp.service;

import com.example.GreetingApp.entity.Greeting;
import com.example.GreetingApp.entity.User;
import com.example.GreetingApp.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingServiceImpl implements GreetingService{

    @Autowired
    private GreetingRepository greetingRepository;

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Override
    public Greeting addGreeting(User user) {
        String message = String.format(template, (user.toString().isEmpty()) ? "Hello World" : user.toString());
        return greetingRepository.save(new Greeting(counter.incrementAndGet(), message));
    }

    @Override
    public Greeting getGreetingById(long id){
        return null;
    }

    @Override
    public Greeting updateGreeting(long id,User user) {
        String message = String.format(template,user.toString());
        return greetingRepository.findById(id).
                map(greeting -> {
                    greeting.setMessage(message);
                    return this.greetingRepository.save(greeting);
                }).get();
    }

    @Override
    public Greeting deleteGreeting(Long id) {
        return greetingRepository.findById(id).map(greeting -> {
            this.greetingRepository.deleteById(id);
            return greeting;
        }).get();
    }

}
