package com.converter.persistence.microsoft;

import com.converter.model.microsoft.MicrosoftStartTimeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MicrosoftStartTimeRepository extends JpaRepository<MicrosoftStartTimeEntity, Integer> {
}