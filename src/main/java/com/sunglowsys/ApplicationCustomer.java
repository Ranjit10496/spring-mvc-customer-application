package com.sunglowsys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApplicationCustomer {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationCustomer.class, args);
        System.out.println("run");

    }
}
