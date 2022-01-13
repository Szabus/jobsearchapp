package com.szendroi.job.services;

import com.szendroi.job.models.Position;
import com.szendroi.job.repositories.ClientRepo;
import com.szendroi.job.repositories.PositionRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class PositionService {

    private ClientRepo clientRepo;
    private PositionRepo positionRepo;

    public boolean apiValidation(UUID id) {
        try {
            if (clientRepo.existsById(id)) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Invalid UUID");
        }
        return false;
    }

    @Transactional
    public boolean registerPosition(Position position, UUID id) {
        try {
            if (apiValidation(id)) {
                positionRepo.save(position);
                return true;
            }
        } catch (Exception e) {
            System.out.println("Invalid name/location");
        }
        return false;
    }

    public List<Position> searchedPositions(String searchedLocation, String searchedPosition) {

        return positionRepo.findByLocationIgnoreCaseAndPositionNameContainingIgnoreCase
                (searchedLocation, searchedPosition);
    }
}
