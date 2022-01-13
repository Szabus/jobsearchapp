package com.szendroi.job.dataloader;

import com.szendroi.job.models.Client;
import com.szendroi.job.models.Position;
import com.szendroi.job.repositories.ClientRepo;
import com.szendroi.job.repositories.PositionRepo;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@AllArgsConstructor
public class DataLoader {

    private final ClientRepo clientRepo;
    private final PositionRepo positionRepo;

    @Bean
    public CommandLineRunner testData() {

        Client firstTestClient = new Client("dumbledore","albus@roxfort.com");

        Client secondTestClient = new Client("Mcglagony", "mc@mc.com");

        Position firstTestPosition = new Position("Java developer", "Hungary");

        Position secondTestPosition = new Position("teacher", "London");

        return args -> {
            clientRepo.save(firstTestClient);
            clientRepo.save(secondTestClient);
            positionRepo.save(firstTestPosition);
            positionRepo.save(secondTestPosition);

            List<Client> clientList = clientRepo.findAll();
            System.out.println(clientList);
            System.out.println(clientList.get(0).getId());
            System.out.println(clientList.get(1).getUserName());

            List<Position> positionList = positionRepo.findByLocationIgnoreCaseAndPositionNameContainingIgnoreCase("london","EACH");
            System.out.println(positionList.get(0).getPositionName());
            System.out.println(clientRepo.existsById(clientList.get(0).getId()));
            };
        }
    }
