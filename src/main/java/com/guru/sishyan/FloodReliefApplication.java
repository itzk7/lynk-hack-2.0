package com.guru.sishyan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class FloodReliefApplication {
    public static void main(String args[]){
        SpringApplication.run(FloodReliefApplication.class,args);
    }
}
