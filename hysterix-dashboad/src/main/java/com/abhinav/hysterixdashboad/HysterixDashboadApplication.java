package com.abhinav.hysterixdashboad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class HysterixDashboadApplication {

	public static void main(String[] args) {
		SpringApplication.run(HysterixDashboadApplication.class, args);
	}

}
