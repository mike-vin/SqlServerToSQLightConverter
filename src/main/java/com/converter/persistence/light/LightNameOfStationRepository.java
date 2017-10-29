package com.converter.persistence.light;

import com.converter.model.LIGHT.NameOfStationEntity;
import com.converter.model.StationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LightNameOfStationRepository extends JpaRepository<NameOfStationEntity, Integer> {
}