package org.bigjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableJms //开启基于JMS的注解
@EnableScheduling
public class Day12Application {

	public static void main(String[] args) {
		SpringApplication.run(Day12Application.class, args);
	}

}
