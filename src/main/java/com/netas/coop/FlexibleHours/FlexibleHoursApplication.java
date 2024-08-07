package com.netas.coop.FlexibleHours;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class FlexibleHoursApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlexibleHoursApplication.class, args);
	}

}
