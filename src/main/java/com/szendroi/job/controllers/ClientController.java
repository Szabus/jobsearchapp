package com.szendroi.job.controllers;

import com.szendroi.job.models.Client;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@AllArgsConstructor
public class ClientController {

    @PostMapping("/clients")
    public UUID registerClient(@RequestBody Client client) {

        return client.getId();
    }
}
