package com.project.availabilityservice;

import com.project.availabilityservice.model.Availablity;
import com.project.availabilityservice.repository.AvailablityRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AvailabilityServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AvailabilityServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(AvailablityRepository availablityRepository){
		return args -> {
			Availablity availablity = new Availablity();
			availablity.setCourseCode("CS103");
			availablity.setSlots(50);

			Availablity availablity1 = new Availablity();
			availablity1.setCourseCode("CS104");
			availablity1.setSlots(0);

			availablityRepository.save(availablity);
			availablityRepository.save(availablity1);

		};
	}
}
