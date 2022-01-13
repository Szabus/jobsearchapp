package com.szendroi.job.repositories;

import com.szendroi.job.models.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PositionRepo extends JpaRepository<Position, Long> {
    List<Position> findByPositionNameContainingIgnoreCase(String searchPosition);

    List<Position> findByLocationContainingIgnoreCase(String searchLocation);

    List<Position> findByLocationIgnoreCaseAndPositionNameContainingIgnoreCase(String location, String position);
}
