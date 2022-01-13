package com.szendroi.job.dataloader;

import com.szendroi.job.models.Client;
import com.szendroi.job.models.Position;
import com.szendroi.job.repositories.ClientRepo;
import com.szendroi.job.repositories.PositionRepo;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class DataLoader {

    private final ClientRepo clientRepo;
    private final PositionRepo positionRepo;

    @Bean
    public CommandLineRunner testData() {

        Client firstTestClient = new Client("Test Elek","test1@gmail.com");

        Client secondTestClient = new Client("Test Vera", "test2@test.com");

        Position firstTestPosition = new Position("Java developer", "Hungary");

        Position secondTestPosition = new Position("teacher", "London");

        return args -> {
            clientRepo.save(firstTestClient);
            clientRepo.save(secondTestClient);
            positionRepo.save(firstTestPosition);
            positionRepo.save(secondTestPosition);
            };
        }
    }
