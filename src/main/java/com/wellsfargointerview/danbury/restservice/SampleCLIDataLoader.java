package com.wellsfargointerview.danbury.restservice;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
@Slf4j
class SampleCLIDataLoader {

    @Bean
    CommandLineRunner initDatabase(TaskRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Task("Produce Forms", "Fargo Danbury ", LocalDate.now())));
            log.info("Preloading " + repository.save(new Task("Close Forms", "Fargo Head Quarters ",  LocalDate.now())));
        };
    }
}

