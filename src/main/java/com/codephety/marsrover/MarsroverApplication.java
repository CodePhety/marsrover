package com.codephety.marsrover;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.*")
public class MarsroverApplication {

    public static void main(String[] args) {
        SpringApplication.run(MarsroverApplication.class, args);
    }

}
