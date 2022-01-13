package com.szendroi.job.services;

import com.szendroi.job.exceptions.JobPlatformExceptions;
import com.szendroi.job.models.Client;
import com.szendroi.job.repositories.ClientRepo;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ClientService {


    ClientRepo clientRepo;

}
