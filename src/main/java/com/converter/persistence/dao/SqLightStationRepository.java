package com.converter.persistence.dao;

import com.converter.model.StationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SqLightStationRepository extends JpaRepository<StationEntity, Integer> {
}
