package com.converter.persistence.light;

import com.converter.model.light.LightStartTimeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LightStartTimeRepository extends JpaRepository<LightStartTimeEntity, Integer> {
}