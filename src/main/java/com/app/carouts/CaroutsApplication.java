package com.app.carouts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CaroutsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CaroutsApplication.class, args);
	}

}
