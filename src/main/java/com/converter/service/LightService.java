package com.converter.service;

import com.converter.model.light.LightNameOfStationEntity;
import com.converter.model.light.LightStartTimeEntity;
import com.converter.model.microsoft.MicrosoftNameOfStationEntity;
import com.converter.model.microsoft.MicrosoftStartTimeEntity;
import com.converter.persistence.light.LightNameOfStationRepository;
import com.converter.persistence.light.LightStartTimeRepository;
import com.converter.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.converter.util.Util.convertList;

@Service
@Transactional(transactionManager = "lightJpaTransactionManager")
public class LightService {
    private final LightNameOfStationRepository nameOfStationRepository;
    private final LightStartTimeRepository startTimeRepository;

    @Autowired
    public LightService(LightNameOfStationRepository nameOfStationRepository, LightStartTimeRepository startTimeRepository) {
        this.nameOfStationRepository = nameOfStationRepository;
        this.startTimeRepository = startTimeRepository;
    }

    public List<LightStartTimeEntity> saveStartTime(List<MicrosoftStartTimeEntity> microsoftStartTimeList) {
        List<LightStartTimeEntity> timeEntities = Util.convertList(microsoftStartTimeList, LightStartTimeEntity::new);
        return startTimeRepository.save(timeEntities);
    }

    public List<LightNameOfStationEntity> saveStations(List<MicrosoftNameOfStationEntity> nameOfStationList) {
        List<LightNameOfStationEntity> lightNameOfStations = Util.convertList(nameOfStationList, LightNameOfStationEntity::new);
        return nameOfStationRepository.save(lightNameOfStations);
    }


    public List<LightNameOfStationEntity> getAllStations() {
        return nameOfStationRepository.findAll();
    }

    public List<LightStartTimeEntity> getAllStartTime() {
        return startTimeRepository.findAll();
    }
}