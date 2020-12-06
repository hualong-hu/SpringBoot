package org.bigjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class Day13Application {

	public static void main(String[] args) {
		SpringApplication.run(Day13Application.class, args);
	}

}
