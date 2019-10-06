package com.abhinav.edgeservice.service;

import com.abhinav.edgeservice.entities.Person;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigInteger;
import java.util.Optional;

@FeignClient("person-service")
public interface PersonServiceClient {
    @GetMapping("/{id}")
    public Optional<Person> getById(@PathVariable("id") BigInteger id);
}
