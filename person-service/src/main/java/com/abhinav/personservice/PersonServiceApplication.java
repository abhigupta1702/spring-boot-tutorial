package com.abhinav.personservice;

import com.abhinav.personservice.entities.Person;
import com.abhinav.personservice.repository.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import java.math.BigInteger;

@SpringBootApplication
@EnableCaching
public class PersonServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner seedDatabse(PersonRepository personRepository) {
		return args -> {
			personRepository.save(Person.builder()
					.id(BigInteger.valueOf(1))
					.name("John Snow")
					.place("Winterfell")
					.build());
			personRepository.save(Person.builder()
					.id(BigInteger.valueOf(2))
					.name("Tyrion Lannister")
					.place("Casterly Rock")
					.build());
			personRepository.save(Person.builder()
					.id(BigInteger.valueOf(3))
					.name("Khaleesi")
					.place("Mereen")
					.build());
			personRepository.save(Person.builder()
					.id(BigInteger.valueOf(4))
					.name("Night King")
					.place("Beyond the wall")
					.build());
		};
	}
}
