package com.szendroi.job.controllers;

import com.szendroi.job.models.Client;
import com.szendroi.job.services.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@AllArgsConstructor
public class ClientController {

    ClientService clientService;

    @PostMapping("/clients")
    public UUID registerClient(@RequestBody Client client) {
        clientService.register(client);
        return client.getId();
    }
}
