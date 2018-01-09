package com.converter.persistence.light;

import com.converter.model.light.LightNameOfStationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LightNameOfStationRepository extends JpaRepository<LightNameOfStationEntity, Integer> {
}