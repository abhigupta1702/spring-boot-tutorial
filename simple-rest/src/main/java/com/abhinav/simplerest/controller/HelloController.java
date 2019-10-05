package com.abhinav.simplerest.controller;

import com.abhinav.simplerest.entities.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/")
    public String hello() {
        return "Hello!";
    }

    @GetMapping("/person")
    public Person person() {
        return new Person("A", 20, "D");
    }
}
