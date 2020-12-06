package org.bigjava;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "org.bigjava.mapper")
@SpringBootApplication
public class Day04Application {

    public static void main(String[] args) {
        SpringApplication.run(Day04Application.class, args);
    }

}
