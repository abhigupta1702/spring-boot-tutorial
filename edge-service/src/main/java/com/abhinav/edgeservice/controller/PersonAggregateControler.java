package com.abhinav.edgeservice.controller;

import com.abhinav.edgeservice.entities.Person;
import com.abhinav.edgeservice.service.PersonServiceClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigInteger;

@RestController
@AllArgsConstructor
public class PersonAggregateControler {
    private final RestTemplate restTemplate;
    private final PersonServiceClient personServiceClient;

    @GetMapping("/feign/{id}")
    @HystrixCommand(fallbackMethod = "getDefaultPerson")
    public Person getPersonFeign(@PathVariable String id) {
        return personServiceClient.getById(new BigInteger(id)).get();
    }

    public Person getDefaultPerson(@PathVariable String id) {
        return new Person(new BigInteger("88"), "ABC", "place");
    }

    @GetMapping("/person/{id}")
    public Person getPerson(@PathVariable String id) {
        ResponseEntity<Person> responseEntity = this.restTemplate.exchange("http://person-service/{id}",
                HttpMethod.GET, null, Person.class, id);
        return responseEntity.getBody();
    }
}
