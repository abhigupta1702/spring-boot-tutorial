package com.abhinav.armyservice;

import com.abhinav.armyservice.entities.Army;
import com.abhinav.armyservice.respository.ArmyRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ArmyServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArmyServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner seedDatabse(ArmyRepository armyRepository) {
		return args -> {
			armyRepository.save(Army.builder()
					.personId(1L)
					.dragons(0)
					.kights(1)
					.ships(2)
					.soldiers(500)
					.build());
			armyRepository.save(Army.builder()
					.personId(2L)
					.dragons(0)
					.kights(10)
					.ships(20)
					.soldiers(700)
					.build());
			armyRepository.save(Army.builder()
					.personId(3L)
					.dragons(3)
					.kights(10)
					.ships(0)
					.soldiers(5000)
					.build());
			armyRepository.save(Army.builder()
					.personId(4L)
					.dragons(0)
					.kights(1)
					.ships(2)
					.soldiers(1000)
					.build());
		};
	}

}
