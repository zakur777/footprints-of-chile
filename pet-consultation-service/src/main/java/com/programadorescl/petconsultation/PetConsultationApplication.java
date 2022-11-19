package com.programadorescl.petconsultation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class PetConsultationApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetConsultationApplication.class, args);
    }
}
