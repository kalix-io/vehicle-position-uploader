package com.matthewcasperson.vehicleposition;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class VehiclePositionApplication {

	public static void main(String[] args) {
		SpringApplication.run(VehiclePositionApplication.class, args);
	}

}
