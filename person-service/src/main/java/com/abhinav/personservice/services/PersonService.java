package com.abhinav.personservice.services;

import com.abhinav.personservice.entities.Person;
import com.abhinav.personservice.repository.PersonRepository;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class PersonService {
    PersonRepository personRepository;

    public Stream<Person> getByName(String name) {
        return personRepository.findByNameContaining(name);
    }

    public Stream<Person> getByPlace(String name) {
        return personRepository.findByPlaceIgnoringCase(name);
    }

    public Stream<Person> getAll() {
        return personRepository.findAll().stream();
    }

    public Optional<Person> getById(BigInteger id) {
        return personRepository.findById(id);
    }

    public Person save (Person person) {
        return personRepository.save(person);
    }

    @SneakyThrows
    @Cacheable("cacheKey")
    public String cacheableMethod(String input) {
        Thread.sleep(2000);
        return UUID.randomUUID().toString();
    }
}
