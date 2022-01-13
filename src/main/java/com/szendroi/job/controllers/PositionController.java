package com.szendroi.job.controllers;

import com.szendroi.job.models.Position;
import com.szendroi.job.services.PositionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class PositionController {

    PositionService positionService;

    @PostMapping(path = "/positions")
    public ResponseEntity<Position> create(@RequestBody final Position newPosition, UUID id) {

        boolean success = positionService.registerPosition(newPosition, id);
        if (success) {
            return new ResponseEntity<>(newPosition, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(newPosition, HttpStatus.UNAUTHORIZED);
    }

    @GetMapping(path = "/search")
    public ResponseEntity<List<Position>> getSearchedPositions(UUID id, String searchedLocation, String searchedJob) {

        if (positionService.apiValidation(id)) {
            List<Position> searchedJobList = positionService.searchedPositions(searchedLocation, searchedJob);
            return new ResponseEntity<>(searchedJobList, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
    }
}
