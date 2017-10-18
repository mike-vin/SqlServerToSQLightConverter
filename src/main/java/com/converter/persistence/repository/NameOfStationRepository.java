package com.converter.persistence.repository;

import com.converter.model.StationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NameOfStationRepository extends JpaRepository<StationEntity, Integer> {
}
