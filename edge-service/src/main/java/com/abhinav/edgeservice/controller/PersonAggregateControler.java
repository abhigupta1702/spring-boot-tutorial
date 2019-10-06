package com.abhinav.edgeservice.controller;

import com.abhinav.edgeservice.entities.Person;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@AllArgsConstructor
public class PersonAggregateControler {
    private final RestTemplate restTemplate;

    @GetMapping("/person/{id}")
    public Person getPerson(@PathVariable String id) {
        ResponseEntity<Person> responseEntity = this.restTemplate.exchange("http://localhost:9001/{id}",
                HttpMethod.GET, null, Person.class, id);
        return responseEntity.getBody();
    }
}
