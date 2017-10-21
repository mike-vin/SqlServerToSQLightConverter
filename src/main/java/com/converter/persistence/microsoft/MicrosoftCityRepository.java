package com.converter.persistence.microsoft;

import com.converter.model.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MicrosoftCityRepository extends JpaRepository<CityEntity, Integer> {
}
