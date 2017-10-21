package com.converter.persistence.light;

import com.converter.model.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LightCityRepository extends JpaRepository<CityEntity, Integer> {
}