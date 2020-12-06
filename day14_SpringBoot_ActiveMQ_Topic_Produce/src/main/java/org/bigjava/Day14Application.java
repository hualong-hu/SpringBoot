package org.bigjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Day14Application {

	public static void main(String[] args) {
		SpringApplication.run(Day14Application.class, args);
	}

}
