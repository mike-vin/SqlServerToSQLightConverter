package com.converter.persistence.light;

import com.converter.model.StationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LightStationRepository extends JpaRepository<StationEntity, Integer> {
}