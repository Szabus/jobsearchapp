package com.szendroi.job.repositories;

import com.szendroi.job.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClientRepo extends JpaRepository<Client, UUID> {
    boolean existsById(UUID id);
}
