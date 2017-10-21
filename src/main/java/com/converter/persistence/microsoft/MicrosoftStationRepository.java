package com.converter.persistence.microsoft;

import com.converter.model.StationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MicrosoftStationRepository extends JpaRepository<StationEntity, Integer> {
}
