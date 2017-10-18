package com.converter.persistence.dao;

import com.converter.model.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SqLightCityRepository extends JpaRepository<CityEntity, Integer> {
}
