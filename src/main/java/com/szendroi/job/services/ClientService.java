package com.szendroi.job.services;

import com.szendroi.job.models.Client;
import com.szendroi.job.repositories.ClientRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.regex.Pattern;

@Service
@AllArgsConstructor
public class ClientService {


    private ClientRepo clientRepo;

    public boolean emailValidator(String email) {
        String pattern = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|" +
                "\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])" +
                "*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:(2(5[0-5]|" +
                "[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*" +
                "[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
        return Pattern.compile(pattern)
                .matcher(email)
                .matches();
    }

    @Transactional
    public boolean register(Client client) {
        try {
            if (emailValidator(client.getEmail())) {
                clientRepo.save(client);
                return true;
            }
        } catch (Exception e) {
            System.out.println("Invalid e-mail.");
        }
        return false;
    }
}
