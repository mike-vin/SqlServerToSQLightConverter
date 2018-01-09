package com.converter.persistence.microsoft;

import com.converter.model.microsoft.MicrosoftNameOfStationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MicrosoftNameOfStationRepository extends JpaRepository<MicrosoftNameOfStationEntity, Integer> {
}
